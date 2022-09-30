package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class AssetManager {

    private final ArrayList<Asset> assets;

    public AssetManager() {
        assets = new ArrayList<>();
    }

    public void add(Asset asset) {
        Objects.requireNonNull(asset);
        assets.add(asset);
    }

    public double profitPerNight() {
        return assets.stream().mapToDouble(Asset::profitPerNight).sum();
    }

    public List<Asset> lowestEfficiency(double efficiency) {
        return assets.stream().filter(asset -> asset.efficiency() <= efficiency).toList();
    }

    public void remove(double efficiency) {
        assets.removeIf(asset -> asset.efficiency() <= efficiency);
    }

    @Override
    public String toString() {
        return assets.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }
}
