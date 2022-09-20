package gt.uvg.pokelist.api

import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.model.Post
import gt.uvg.pokelist.utils.Constants.Companion.RETRIEVED
import retrofit2.http.GET

interface SimpleApi {
    @GET("pokemon?limit=$RETRIEVED")
    suspend fun getPost(): Post
}