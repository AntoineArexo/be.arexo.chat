package com.appstart

class Mapper {
    def getMap(Object o, Map options) {
        def map
        
        if (o instanceof Collection) {
            map = o.collect{it ->
                def tmp = it.transformToMap()
                return parseToMap(tmp)
            }
        }
        else {
            map = o.transformToMap()
            map = parseToMap(map)
        }
        
        if (options[MapperOption.root]) {
            map = ["${options[MapperOption.root]}":map]
        }
        
        return map
    }
    
    def parseToMap(map) {
        if (map instanceof Collection) {
            return map.collect{parseToMap(it)}
        }
        if (map instanceof Map) {
            def newMap = [:]
            map.each{key, val ->
                if (val instanceof Map || val instanceof Collection) {
                    val = parseToMap(val)
                }
                newMap[key] = val
            }
            return newMap
        }
        return map;
    }
}

