package com.kotlinhero.products

import android.app.Application
import com.kotlinhero.products.di.AppModule
import com.kotlinhero.products.di.KtorModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class ProductsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@ProductsApplication)
            modules(
                KtorModule,
                AppModule
            )
        }
    }
}