package com.appstart

class Mapper {
    static def getMap(Object o, Map options) {
        def map = [:]
        def dependencies = [:]
        
        if (o instanceof Collection) {
            map[o[0].getRootName(true, options)] = o.collect{
                dependencies = mergeMap(dependencies, it.mapDependencies(true, options))
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
        return one + two
    }
}
