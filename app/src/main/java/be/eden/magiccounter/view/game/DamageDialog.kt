package be.eden.magiccounter.view.game

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.DialogFragment
import be.eden.magiccounter.R
import be.eden.magiccounter.enumeration.PlayerNumber
import be.eden.magiccounter.enumeration.PointType
import be.eden.magiccounter.model.DamageSendListener

class DamageDialog(
    private val pointType: PointType,
    private val playerNumber : PlayerNumber,
    private val listener : DamageSendListener
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)

            val view = requireActivity().layoutInflater.inflate(R.layout.dialog_damage, null)

            val damageNumber = view.findViewById<AppCompatEditText>(R.id.damageNumber)


            builder.setTitle(when(pointType) {
                PointType.DAMAGE -> R.string.damage_inflicted
                PointType.HEAL -> R.string.damage_healed
            })
                .setView(view)
                .setPositiveButton(R.string.inflict) { dialog, _ ->
                    var damage : Int = damageNumber.text.toString().toInt()

                    if(pointType == PointType.DAMAGE){
                        damage *= -1
                    }

                    listener.onDamageSend(playerNumber, damage)
                    dialog.dismiss()
                }
                .setNegativeButton(R.string.cancel) { dialog, _ ->
                    dialog.cancel()
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}