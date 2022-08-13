package com.aya.newsapp.utils

    private val SECOND_MILLIS = 1000
    private val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private val DAY_MILLIS = 24 * HOUR_MILLIS

    fun getTimeAgo(t:Long):String? {
        var time = t
        if (time < 1000000000000L) {
            time *= 1000;
        }
        val now = System.currentTimeMillis()
        if (time > now || time <= 0) {
            return null
        }

        val  diff :Long = now - time;

        if (diff < MINUTE_MILLIS) {
            return "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return (diff / MINUTE_MILLIS).toString().plus(" minutes ago")
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return (diff / HOUR_MILLIS).toString().plus(" hours ago")
        } else if (diff < 48 * HOUR_MILLIS) {
            return "yesterday";
        } else {
            return (diff / DAY_MILLIS).toString().plus( " days ago")
        }
    }
