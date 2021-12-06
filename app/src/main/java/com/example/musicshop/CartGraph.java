package com.example.musicshop;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

//@Component (dependencies = {}, modules = {AppModule.class, RoomModule.class})
interface CartGraph {
    //void inject (MainActivity mainActivity);
    //CartDao cartDao();

}

@Module
class AppModule {
    Application mApplication;
    public AppModule (Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return mApplication;
    }
}

@Module
class RoomModule {
    private CartDB cartDB;
    public RoomModule (Application mApplication){
        cartDB = Room.databaseBuilder(mApplication, CartDB.class, "cart_db").build();
    }

    @Singleton
    @Provides
    CartDB prRoomDatabase(){
        return cartDB;

    }

    @Singleton
    @Provides
    CartDao prCartDao (CartDB cartdb){
        return cartdb.getCartDao();
    }
}
