package com.company.dpassignment1.ducks;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecentAction {

    @JsonProperty("canUndo")
    private boolean canUndo;
    @JsonProperty("canRedo")
    private boolean canRedo;

    public boolean isCanUndo() {
        return canUndo;
    }

    public void setCanUndo(boolean canUndo) {
        this.canUndo = canUndo;
    }

    public boolean isCanRedo() {
        return canRedo;
    }

    public void setCanRedo(boolean canRedo) {
        this.canRedo = canRedo;
    }
}
