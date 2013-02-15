package com.appstart

class Mapper {
    static def getMap(Object o, Map options) {
        def map = [:]
        def dependencies = [:]
        
        if (o instanceof Collection) {
            map[o[0].getRootName(true, options)] = o.collect{ 
                dependencies = mergeMap(dependencies, it.mapDependencies(true, options))
                
                it.mapDependencies(true, options).each{key, value -> 
                    dependencies[key] = dependencies[key]+value.findAll{ depValue ->
                        return !dependencies[key].contains(depValue)
                    }
                }
                
                
                it.transformToMap(true, options)
            }
        }
        else {
            map[o.getRootName(false, options)] = o.transformToMap(false, options)
            dependencies = mergeMap(dependencies, o.mapDependencies(false, options))
        }
        
        dependencies.each{key, value ->
            def tmpMap = getMap(key.getAll(value), options)
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
