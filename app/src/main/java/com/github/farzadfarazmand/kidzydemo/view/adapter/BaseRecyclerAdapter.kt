package com.github.farzadfarazmand.kidzydemo.view.adapter

import java.util.*


abstract class BaseRecyclerAdapter<T, VH : androidx.recyclerview.widget.RecyclerView.ViewHolder>(objects: MutableList<T>) : androidx.recyclerview.widget.RecyclerView.Adapter<VH>() {

    private var mObjects: MutableList<T> = objects

    val allItems: List<T>
        get() = mObjects

    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    fun add(item: T?) {
        item?.let {
            mObjects.add(it)
            notifyItemInserted(itemCount - 1)
        }
    }

    fun addToPosition(position: Int, item: T?) {
        item?.let {
            mObjects.add(position, it)
            notifyItemInserted(position)
        }
    }

    fun addAll(items: List<T>?) {
        items?.let {
            val oldSize = mObjects.size
            mObjects.addAll(items)
            notifyItemRangeInserted(oldSize, mObjects.size)
        }
    }

    /**
     * Remove all elements from the list.
     */
    fun clear() {
        val size = itemCount
        mObjects.clear()
        mObjects = arrayListOf()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = if (mObjects.size == 0) 0 else mObjects.size

    fun getItem(position: Int): T = mObjects[position]

    override fun getItemId(position: Int): Long = position.toLong()

    /**
     * Returns the position of the specified item in the array.
     *
     * @param item The item to retrieve the position of.
     * @return The position of the specified item.
     */
    fun getPosition(item: T): Int = mObjects.indexOf(item)

    /**
     * Inserts the specified object at the specified index in the array.
     *
     * @param object The object to insert into the array.
     * @param index  The index at which the object must be inserted.
     */
    fun insert(`object`: T, index: Int) {
        `object`.let {
            mObjects.add(index, `object`)
            notifyItemInserted(index)
        }
    }

    /**
     * update the specified object.
     *
     * @param object The object to update.
     */

    fun update(`object`: T) {
        val position = getPosition(`object`)
        mObjects[position] = `object`
        notifyItemChanged(position)
    }

    /**
     * Removes the specified object from the array.
     *
     * @param object The object to remove.
     */
    fun remove(`object`: T) {
        val position = getPosition(`object`)
        mObjects.remove(`object`)
        notifyItemRemoved(position)
    }

    fun removeWithoutNotify(`object`: T) {
        mObjects.remove(`object`)
    }

    /**
     * Sorts the content of this adapter using the specified comparator.
     *
     * @param comparator The comparator used to sort the objects contained in this adapter.
     */
    fun sort(comparator: Comparator<in T>) {
        Collections.sort(mObjects, comparator)
        notifyItemRangeChanged(0, itemCount)
    }
}