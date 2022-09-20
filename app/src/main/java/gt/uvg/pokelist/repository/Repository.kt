package gt.uvg.pokelist.repository

import gt.uvg.pokelist.api.RetrofitInstance
import gt.uvg.pokelist.model.Post

class Repository {
    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}