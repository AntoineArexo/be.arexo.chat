package com.appstart

enum MapperOption {
    root('root'),
    withDependency('withDependency')
    
    private final String value
    
    private MapperOption(String value){
        this.value = value
    }
    String value(){value}
}

