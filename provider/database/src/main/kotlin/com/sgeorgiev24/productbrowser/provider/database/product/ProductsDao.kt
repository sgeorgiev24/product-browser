package com.sgeorgiev24.productbrowser.provider.database.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductsDao {
    @Query("SELECT * FROM products")
    suspend fun getFavoriteProducts(): List<ProductEntity>

    @Query("DELETE FROM products WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: ProductEntity)

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getFavoriteProductById(id: Int): ProductEntity
}