package tech.min.tarzen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.min.tarzen.data.source.DefaultUserRepository
import tech.min.tarzen.data.source.UserRepository

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(
        userRepository: DefaultUserRepository
    ): UserRepository
}