package com.example.popularmovie.core.di

import android.content.Context
import androidx.room.Room
import com.example.popularmovie.core.data.source.local.room.MovieDao
import com.example.popularmovie.core.data.source.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : MovieDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("movie".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java, "MoviePopular.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }



    @Provides
    fun provideMovieDao(database: MovieDatabase) : MovieDao = database.movieDao()
}*/
val databaseModule = module {
    factory { get<MovieDatabase>().movieDao() }
    single {
        val key : ByteArray = SQLiteDatabase.getBytes("movie".toCharArray())
        val factory = SupportFactory(key)
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, "MoviePopularNew.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}