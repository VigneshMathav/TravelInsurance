package com.spiderindia.travelinsurance.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

open class TIBaseActivity : AppCompatActivity() {

    var mTILoaderFragment: TILoaderFragment? = null

    fun showProgressDialog(tag: String)
    {
        val curr = supportFragmentManager.findFragmentByTag(tag)
        curr?.let {
            val dialogFragment = it as? DialogFragment
            dialogFragment?.dismiss()

            val transaction = supportFragmentManager.beginTransaction()
            transaction.remove(it)
            transaction.commit()
        }
        mTILoaderFragment = TILoaderFragment()
        mTILoaderFragment?.isCancelable = false

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(mTILoaderFragment!!,tag)
        transaction.commitAllowingStateLoss()
    }

    fun dismissProgressDialog(tag: String)
    {
        mTILoaderFragment?.let {
            if (it.isVisible)
            {
                it.dismissAllowingStateLoss()
            }
        }
    }


}