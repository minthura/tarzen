package tech.min.tarzen.ui.dialog

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import tech.min.tarzen.R

class TarzenDialog {
    companion object{
        fun showDialog(context: Context, title: String?, message: String?){
            MaterialAlertDialogBuilder(context).apply {
                setTitle(title)
                setMessage(message)
                setNeutralButton(context.getString(R.string.cancel)) { dialog, which ->
                    // Respond to neutral button press
                }
                setNegativeButton(context.getString(R.string.decline)) { dialog, which ->
                    // Respond to negative button press
                }
                setPositiveButton(context.getString(R.string.accept)) { dialog, which ->
                    // Respond to positive button press
                }
            }.show()
        }
    }
}