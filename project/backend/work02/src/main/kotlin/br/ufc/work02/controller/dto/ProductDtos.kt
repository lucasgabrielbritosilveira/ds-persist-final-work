package br.ufc.work02.controller.dto

import br.ufc.work02.domain.model.Category
import br.ufc.work02.domain.model.GenericDto
import br.ufc.work02.domain.model.Manufacturer
import br.ufc.work02.domain.model.Product
import java.util.*

data class ProductDtoIn(
        val id: Long?,
        val name: String,
        val price: Double,
        val manufacturerId: Long?,
        val manufacturingDate: Date,
        val expirationDate: Date,
        val categoryId: Long?,
        val amount: Int
) : GenericDto<Product> {

    lateinit var category: Category
    lateinit var manufacturer : Manufacturer

    constructor(model: Product) : this(
        id = model.id,
        name = model.name,
        price = model.price,
        manufacturerId = model.manufacturer.id,
        manufacturingDate = model.manufacturingDate,
        expirationDate = model.expirationDate,
        categoryId = model.category.id,
        amount = model.amount
    )

    fun setProductCategory(productCategory: Category){
        this.category = productCategory
    }

    fun setProductManufacturer(manufacturer: Manufacturer){
        this.manufacturer = manufacturer
    }

    override fun toModel(): Product {
        return Product(
            name = name, price = price, manufacturer = manufacturer, manufacturingDate = manufacturingDate,
                expirationDate = expirationDate, category = category, amount = amount
        )
    }
}

data class ProductDtoOut(
    val id: Long?,
    val name: String,
    val price: Double,
    val manufacturer: Manufacturer,
    val manufacturingDate: Date,
    val expirationDate: Date,
    val category: Category,
    val amount: Int
)

