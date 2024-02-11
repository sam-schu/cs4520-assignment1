package com.cs4520.assignment1.logic

data class Product(val name: String, val type: Type, val expiryDate: String?, val price: Int) {
    enum class Type {
        EQUIPMENT,
        FOOD
    }

    companion object {
        fun fromDataList(data: List<Any?>): Product {
            if (data.size != 4) {
                throw IllegalArgumentException(
                    "Exactly 4 data items must be provided to initialize a product"
                )
            }

            val name = data[0] as? String ?: throw IllegalArgumentException(
                "The first data item (the product name) must be a String"
            )

            val type = when (data[1]) {
                "Equipment" -> Type.EQUIPMENT
                "Food" -> Type.FOOD
                else -> throw IllegalArgumentException(
                    "The second data item (the product type) must be either \"Equipment\" or "
                    + "\"Food\""
                )
            }

            val expiryDate: String? = data[2].let {
                if (it is String?) it else throw IllegalArgumentException(
                    "The third data item (the expiry date) must be either a String or null"
                )
            }

            val price = data[3] as? Int ?: throw IllegalArgumentException(
                "The fourth data item (the price) must be an Int"
            )

            return Product(name, type, expiryDate, price)
        }
    }
}

class ProductManager() {
    private val products: MutableList<Product> = mutableListOf()

    fun importProductData(data: List<List<Any?>>) {
        products.addAll(data.map { Product.fromDataList(it) })
    }

    fun getAllProducts(): List<Product> = products.toList()
}


















