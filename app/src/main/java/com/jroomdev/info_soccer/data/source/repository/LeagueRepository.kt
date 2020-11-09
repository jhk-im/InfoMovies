/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jroomdev.info_soccer.data.source.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.jroomdev.info_soccer.data.source.local.LeagueDao
import com.jroomdev.info_soccer.data.source.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LeagueRepository @Inject constructor(
    private val retrofitClient: RetrofitClient,
    private val leagueDao: LeagueDao
):Repository {

    @WorkerThread
    suspend fun getLeagues(
        page: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        var leagues = leagueDao.getLeagueList(page)
        if (leagues.isEmpty()) {
            Log.e("Network","implementing...")
        } else {
            emit(leagues)
        }
    }.flowOn(Dispatchers.IO)
}