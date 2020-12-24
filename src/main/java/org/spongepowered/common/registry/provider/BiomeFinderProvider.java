/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.common.registry.provider;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.world.biome.ColumnFuzzedBiomeMagnifier;
import net.minecraft.world.biome.DefaultBiomeMagnifier;
import net.minecraft.world.biome.FuzzedBiomeMagnifier;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.world.biome.BiomeFinder;

public final class BiomeFinderProvider {

    public static BiomeFinderProvider INSTANCE = new BiomeFinderProvider();

    private final BiMap<ResourceKey, BiomeFinder> mappings;

    private BiomeFinderProvider() {
        this.mappings = HashBiMap.create();

        this.mappings.put(ResourceKey.sponge("column_fuzzed"), (BiomeFinder) (Object) ColumnFuzzedBiomeMagnifier.INSTANCE);
        this.mappings.put(ResourceKey.sponge("fuzzy"), (BiomeFinder) (Object) FuzzedBiomeMagnifier.INSTANCE);
        this.mappings.put(ResourceKey.sponge("default"), (BiomeFinder) (Object) DefaultBiomeMagnifier.INSTANCE);
    }

    @Nullable
    public BiomeFinder get(final ResourceKey key) {
        return this.mappings.get(key);
    }

    @Nullable
    public ResourceKey get(final BiomeFinder biomeFinder) {
        return this.mappings.inverse().get(biomeFinder);
    }
}
