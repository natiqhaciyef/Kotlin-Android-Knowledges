package com.natiqhaciyef.kotlinandroidknowledges.android.settings

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

object NavigateToSetting : Fragment() {

    val settingsLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

    }

    private fun showNavigateToSettingsDialog() {
        settingsLauncher.launch(
            Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts(
                    "package",
                    requireActivity().packageName,
                    null
                )
            )
        )
    }

    private fun navigateToSetting(){
        val intent = Intent(Settings.ACTION_SETTINGS)
        startActivity(intent)
    }
}