package com.mrsep.musicrecognizer.glue.preferences.di

import com.mrsep.musicrecognizer.core.common.BidirectionalMapper
import com.mrsep.musicrecognizer.core.common.Mapper
import com.mrsep.musicrecognizer.data.preferences.ScheduleActionDo
import com.mrsep.musicrecognizer.data.preferences.UserPreferencesDo
import com.mrsep.musicrecognizer.data.preferences.UserPreferencesDo.*
import com.mrsep.musicrecognizer.feature.preferences.domain.ScheduleAction
import com.mrsep.musicrecognizer.feature.preferences.domain.UserPreferences
import com.mrsep.musicrecognizer.glue.preferences.mapper.PreferencesMapper
import com.mrsep.musicrecognizer.glue.preferences.mapper.RequiredServicesMapper
import com.mrsep.musicrecognizer.glue.preferences.mapper.ScheduleActionMapper
import com.mrsep.musicrecognizer.glue.preferences.mapper.SchedulePolicyMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    fun bindPreferencesMapper(implementation: PreferencesMapper):
            Mapper<UserPreferencesDo, UserPreferences>

    @Binds
    fun bindRequiredServicesMapper(implementation: RequiredServicesMapper):
            BidirectionalMapper<RequiredServicesDo, UserPreferences.RequiredServices>

    @Binds
    fun bindScheduleActionMapper(implementation: ScheduleActionMapper):
            BidirectionalMapper<ScheduleActionDo, ScheduleAction>

    @Binds
    fun bindSchedulePolicyMapper(implementation: SchedulePolicyMapper):
            BidirectionalMapper<SchedulePolicyDo, UserPreferences.SchedulePolicy>


}