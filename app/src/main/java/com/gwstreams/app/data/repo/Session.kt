package com.gwstreams.app.data.repo

import com.gwstreams.app.data.model.UserInfo

/**
 * Holds the active credentials and builds the playable stream URLs.
 * Xtream stream URL patterns:
 *   Live:   {host}/live/{user}/{pass}/{stream_id}.m3u8
 *   VOD:    {host}/movie/{user}/{pass}/{stream_id}.{ext}
 *   Series: {host}/series/{user}/{pass}/{episode_id}.{ext}
 */
object Session {
    var host: String = ""      // normalized, e.g. http://example.com:8080
    var username: String = ""
    var password: String = ""
    var userInfo: UserInfo? = null

    fun liveUrl(streamId: Int): String =
        "$host/live/$username/$password/$streamId.m3u8"

    fun vodUrl(streamId: Int, ext: String?): String =
        "$host/movie/$username/$password/$streamId.${ext ?: "mp4"}"

    fun seriesUrl(episodeId: Int, ext: String?): String =
        "$host/series/$username/$password/$episodeId.${ext ?: "mp4"}"

    /**
     * Catch-up / archive stream (#10). `start` is "Y-MM-DD:HH-MM" in the panel's
     * timezone; `durationMin` is the programme length in minutes.
     * Xtream pattern: {host}/streaming/timeshift.php?username&password&stream&start&duration
     */
    fun archiveUrl(streamId: Int, startUtc: String, durationMin: Int): String =
        "$host/streaming/timeshift.php?username=$username&password=$password" +
            "&stream=$streamId&start=$startUtc&duration=$durationMin"
}
