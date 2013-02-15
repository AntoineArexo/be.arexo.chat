package com.appstart

class Mapper {
    def getMap(Object o, Map options) {
        def map = [:]
        
        if (o instanceof Collection) {
            map[o[0].getRootName(true, options)] = o.collect{it.transformToMap(true, options)}
        }
        else {
            map[o.getRootName(false, options)] = o.transformToMap(false, options)
        }
        
        return map
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
