package com.mrsep.musicrecognizer.feature.preferences.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mrsep.musicrecognizer.core.ui.util.recompositionCounter
import com.mrsep.musicrecognizer.feature.preferences.domain.UserPreferences
import com.mrsep.musicrecognizer.core.strings.R as StringsR

internal class RequiredServicesDialogState(
    initialState: UserPreferences.RequiredServices,
) {
    var spotifyCheckBox by mutableStateOf(initialState.spotify)
    var youtubeCheckBox by mutableStateOf(initialState.youtube)
    var soundCloudCheckBox by mutableStateOf(initialState.soundCloud)
    var appleMusicCheckBox by mutableStateOf(initialState.appleMusic)
    var deezerCheckBox by mutableStateOf(initialState.deezer)
    var napsterCheckBox by mutableStateOf(initialState.napster)
    var musicBrainzCheckBox by mutableStateOf(initialState.musicbrainz)

    val currentState: UserPreferences.RequiredServices
        get() = UserPreferences.RequiredServices(
            spotify = spotifyCheckBox,
            youtube = youtubeCheckBox,
            soundCloud = soundCloudCheckBox,
            appleMusic = appleMusicCheckBox,
            deezer = deezerCheckBox,
            napster = napsterCheckBox,
            musicbrainz = musicBrainzCheckBox
        )

    companion object {
        val Saver: Saver<RequiredServicesDialogState, *> = listSaver(
            save = { listOf(
                it.spotifyCheckBox,
                it.youtubeCheckBox,
                it.soundCloudCheckBox,
                it.appleMusicCheckBox,
                it.deezerCheckBox,
                it.napsterCheckBox,
                it.musicBrainzCheckBox
            ) },
            restore = {
                RequiredServicesDialogState(
                    initialState = UserPreferences.RequiredServices(
                        spotify = it[0],
                        youtube = it[1],
                        soundCloud = it[2],
                        appleMusic = it[3],
                        deezer = it[4],
                        napster = it[5],
                        musicbrainz = it[6]
                    )
                )
            }
        )
    }

}

@Composable
internal fun rememberRequiredServicesDialogState(
    requiredServices: UserPreferences.RequiredServices,
): RequiredServicesDialogState {
    return rememberSaveable(inputs = arrayOf(requiredServices), saver = RequiredServicesDialogState.Saver) {
        RequiredServicesDialogState(
            initialState = requiredServices
        )
    }
}

@Composable
internal fun RequiredServicesDialog(
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit,
    dialogState: RequiredServicesDialogState,
) {
    AlertDialog(
        title = {
            Text(text = "Show links to")
        },
        confirmButton = {
            Button(onClick = onConfirmClick) {
                Text(text = stringResource(StringsR.string.apply))
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismissClick) {
                Text(text = stringResource(StringsR.string.cancel))
            }
        },
        text = {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(StringsR.string.spotify), modifier = Modifier.weight(1f))
                    Checkbox(
                        modifier = Modifier.recompositionCounter("spotifyCheckBox"),
                        checked = dialogState.spotifyCheckBox,
                        onCheckedChange = { dialogState.spotifyCheckBox = it }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(StringsR.string.youtube), modifier = Modifier.weight(1f))
                    Checkbox(
                        modifier = Modifier.recompositionCounter("youtubeCheckBox"),
                        checked = dialogState.youtubeCheckBox,
                        onCheckedChange = { dialogState.youtubeCheckBox = it }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(StringsR.string.soundcloud), modifier = Modifier.weight(1f))
                    Checkbox(
                        modifier = Modifier.recompositionCounter("soundcloudCheckBox"),
                        checked = dialogState.soundCloudCheckBox,
                        onCheckedChange = { dialogState.soundCloudCheckBox = it }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(StringsR.string.apple_music), modifier = Modifier.weight(1f))
                    Checkbox(
                        modifier = Modifier.recompositionCounter("appleMusicCheckBox"),
                        checked = dialogState.appleMusicCheckBox,
                        onCheckedChange = { dialogState.appleMusicCheckBox = it }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(StringsR.string.deezer), modifier = Modifier.weight(1f))
                    Checkbox(
                        modifier = Modifier.recompositionCounter("deezerCheckBox"),
                        checked = dialogState.deezerCheckBox,
                        onCheckedChange = { dialogState.deezerCheckBox = it }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(StringsR.string.napster), modifier = Modifier.weight(1f))
                    Checkbox(
                        modifier = Modifier.recompositionCounter("napsterCheckBox"),
                        checked = dialogState.napsterCheckBox,
                        onCheckedChange = { dialogState.napsterCheckBox = it }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(StringsR.string.musicbrainz), modifier = Modifier.weight(1f))
                    Checkbox(
                        modifier = Modifier.recompositionCounter("musicBrainzCheckBox"),
                        checked = dialogState.musicBrainzCheckBox,
                        onCheckedChange = { dialogState.musicBrainzCheckBox = it }
                    )
                }
            }
        },
        onDismissRequest = { }
    )
}