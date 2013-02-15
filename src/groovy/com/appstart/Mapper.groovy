package com.appstart

class Mapper {
    def getMap(Object o, Map options) {
        def map = [:]
        def dependencies = [:]
        
        if (o instanceof Collection) {
            map[o[0].getRootName(true, options)] = o.collect{
                dependencies = mergeMap(dependencies, [:])//it.mapDependencies(true, options))
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
//        
//        dependencies.each{key, value ->
//            if (key.getClass()) {
//                if (value instanceof Collection) {
//                    value.each{
//                        key.get(it).transformToMap(true, options)
//                    }
//                }
//                else {
//                    map[key.get(value).getRootName(false, options)] = key.get(value).transformToMap(false, options)
//                }
//            }
//        }
//        
        return map
    }
    
    def mergeMap(Map one, Map two) {
        return one + two
    }
    
    // Useless (I think)
//    def parseToMap(map) {
//        if (map instanceof Collection) {
//            return map.collect{parseToMap(it)}
//        }
//        if (map instanceof Map) {
//            def newMap = [:]
//            map.each{key, val ->
//                if (val instanceof Map || val instanceof Collection) {
//                    val = parseToMap(val)
//                }
//                newMap[key] = val
//            }
//            return newMap
//        }
//        return map;
//    }
}
