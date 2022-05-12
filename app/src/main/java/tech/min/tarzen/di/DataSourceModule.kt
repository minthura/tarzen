package tech.min.tarzen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.min.tarzen.data.source.remote.RemoteUserDataSource
import tech.min.tarzen.data.source.UserDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    abstract fun bindUserDataSource(
        userDataSource: RemoteUserDataSource
    ): UserDataSource
}
