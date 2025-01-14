package id.medigo.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.medigo.model.Profile
import io.reactivex.Completable
import io.reactivex.Maybe

@Dao
interface ProfileDao {

    @Query("SELECT * FROM Profile LIMIT 1")
    fun getUser(): Maybe<Profile>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(profile: Profile): Completable

}