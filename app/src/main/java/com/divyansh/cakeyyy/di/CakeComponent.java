package com.divyansh.cakeyyy.di;

import com.divyansh.cakeyyy.di.modules.CakeModule;
import com.divyansh.cakeyyy.di.modules.ContextModule;
import com.divyansh.cakeyyy.network.APIEndpoints;

import dagger.Component;

@Component(modules = {
        CakeModule.class,
        ContextModule.class
})
public interface CakeComponent {
    APIEndpoints getAPIEndpoints();
}
