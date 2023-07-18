package com.example.mvi_android.repository

import com.example.mvi_android.model.Blog
import com.example.mvi_android.remote.BlogAPI
import com.example.mvi_android.remote.NetworkMapper
import com.example.mvi_android.room.BlogDao
import com.example.mvi_android.room.CacheMapper
import com.example.mvi_android.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogApi: BlogAPI,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getBlogs() : Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlogs = blogApi.get()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs){
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlog = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlog)))
//            emit(DataState.Success(blogs))
        } catch (e : Exception){
            emit(DataState.Error(e))
        }
    }

}