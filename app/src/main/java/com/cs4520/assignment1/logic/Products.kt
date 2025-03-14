package com.cs4520.assignment1.logic

/**
 * Represents a single product (equipment or food).
 */
sealed class Product(val name: String, val expiryDate: String?, val price: Int) {

    companion object {
        /**
         * Returns a Product generated from the given list with the following elements:
         * 0: product name (String)
         * 1: product type ("Equipment" or "Food")
         * 2: product expiry date (String), or null if none
         * 3: product price (Int)
         *
         * The returned Product will be either an EquipmentProduct or a FoodProduct, depending on
         * the product type.
         *
         * @throws IllegalArgumentException if the aforementioned list structure is not followed.
         */
        fun fromDataList(data: List<Any?>): Product {
            if (data.size != 4) {
                throw IllegalArgumentException(
                    "Exactly 4 data items must be provided to initialize a product"
                )
            }

            val name = data[0] as? String ?: throw IllegalArgumentException(
                "The first data item (the product name) must be a String"
            )

            val subclassConstructor = when (data[1]) {
                "Equipment" -> ::EquipmentProduct
                "Food" -> ::FoodProduct
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

            return subclassConstructor(name, expiryDate, price)
        }
    }
}

/**
 * Represents a product of the "Equipment" type.
 *
 * Contains a name, a price, and possibly an expiry date.
 */
class EquipmentProduct(name: String, expiryDate: String?, price: Int) :
    Product(name, expiryDate, price)

/**
 * Represents a product of the "Food" type.
 *
 * Contains a name, a price, and possibly an expiry date.
 */
class FoodProduct(name: String, expiryDate: String?, price: Int) : Product(name, expiryDate, price)

/**
 * Manages a list of products and allows products to be mass imported from a list.
 */
class ProductManager() {
    private val products: MutableList<Product> = mutableListOf()

    /**
     * Adds products to the product manager, using data from the given list. Each list element
     * should be a list representing a single product and containing the following elements:
     * 0: product name (String)
     * 1: product type ("Equipment" or "Food")
     * 2: product expiry date (String), or null if none
     * 3: product price (Int)
     *
     * @throws IllegalArgumentException if the aforementioned list structure is not followed for all
     *     products.
     */
    fun importProductData(data: List<List<Any?>>) {
        products.addAll(data.map { Product.fromDataList(it) })
    }

    /**
     * Returns a copy of the list of all products held by the product manager.
     */
    fun getAllProducts(): List<Product> = products.toList()
}