package com.appstart

class Mapper {
    static def getMap(Object o, Map options) {
        def map = [:]
        def dependencies = [:]
        
        // We collect map of element(s)
        if (o instanceof Collection) {
            map[o[0].getRootName(true, options)] = o.collect{
                // We save the dependencies of each element
                dependencies = mergeMap(dependencies, it.mapDependencies(true, options))
                // We collect map of each element
                it.transformToMap(true, options)
            }
        }
        else {
            // If only one element, we get the map and dependencies
            map[o.getRootName(false, options)] = o.transformToMap(false, options)
            dependencies = mergeMap(dependencies, o.mapDependencies(false, options))
        }
        
        // We collect map of dependencies
        dependencies.each{key, value ->
            def tmpMap = getMap(key.getAll(value), options)
            // We add map of dependencies to the current map
            map = mergeMap(map, tmpMap)
        }
        
        return map
    }
    
    static private def mergeMap(Map one, Map two) {
        two.each{key, value -> 
            if (one[key]) {
                one[key] = one[key]+value.findAll{ depValue ->
                    return !one[key].contains(depValue)
                }
            }
            else {
                one[key] = value
            }
        }
        return one;
    }
}
