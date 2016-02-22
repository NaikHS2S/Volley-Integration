package com.telstra.imagelist.network.util;

/**
 * Created by computer on 2/18/2016.
 */

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

public class CustomImageCache extends LruCache<String, Bitmap> implements
        ImageLoader.ImageCache {

    private static final int BUFFER_SIZE = 1024;

    private static int getDefaultLruCacheSize() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / BUFFER_SIZE);
        final int cacheSize = maxMemory / 8;

        return cacheSize;
    }

    public CustomImageCache() {
        this(getDefaultLruCacheSize());
    }

    public CustomImageCache(int sizeInKiloBytes) {
        super(sizeInKiloBytes);
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight() / BUFFER_SIZE;
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }
}
