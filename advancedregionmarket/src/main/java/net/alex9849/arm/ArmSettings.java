package net.alex9849.arm;

public class ArmSettings {
    private boolean isAllowSubRegionUserRestore = false;
    private boolean isSubregionAutoRestore = false;
    private int maxSubRegionMembers = -1;
    private int subRegionPaybackPercentage = 100;
    private boolean isSubregionInactivityReset = false;
    private boolean isTeleportAfterSellRegionBought = false;
    private boolean teleportAfterRentRegionBought = false;
    private boolean isTeleportAfterRentRegionExtend = false;
    private boolean isTeleportAfterContractRegionBought = false;
    private boolean isSendContractRegionExtendMessage = false;
    private boolean isRegionInfoParticleBorder = true;
    private boolean deleteSubregionsOnParentRegionUnsell = false;
    private boolean deleteSubregionsOnParentRegionBlockReset = false;
    private boolean allowParentRegionOwnersBuildOnSubregions = true;
    private boolean removeEntitiesOnRegionBlockReset = true;
    private boolean activateRegionKindPermissions = false;
    private boolean createBackupOnRegionUnsell = true;
    private boolean createBackupOnRegionRestore = true;
    private boolean isAllowTeleportToBuySign = true;
    private long userResetCooldown = 604800000;
    private String signRightClickSneakCommand = "buyaction";
    private String signRightClickNotSneakCommand = "buyaction";
    private String signLeftClickSneakCommand = "buyaction";
    private String signLeftClickNotSneakCommand = "buyaction";
    private String DATE_TIMEFORMAT = "dd.MM.yyyy hh:mm";


    /*###################################
    ############## Getter ###############
    ###################################*/

    public int getSubRegionPaybackPercentage() {
        return subRegionPaybackPercentage;
    }

    public boolean isCreateBackupOnRegionUnsell() {
        return createBackupOnRegionUnsell;
    }

    public int getMaxSubRegionMembers() {
        return maxSubRegionMembers;
    }

    public boolean isCreateBackupOnRegionRestore() {
        return createBackupOnRegionRestore;
    }

    public boolean isActivateRegionKindPermissions() {
        return this.activateRegionKindPermissions;
    }

    public boolean isAllowSubRegionUserRestore() {
        return isAllowSubRegionUserRestore;
    }

    public boolean isSubregionAutoRestore() {
        return isSubregionAutoRestore;
    }

    public boolean isSubregionInactivityReset() {
        return isSubregionInactivityReset;
    }

    public boolean isTeleportAfterSellRegionBought() {
        return isTeleportAfterSellRegionBought;
    }

    public boolean isTeleportAfterRentRegionBought() {
        return teleportAfterRentRegionBought;
    }

    public boolean isTeleportAfterRentRegionExtend() {
        return isTeleportAfterRentRegionExtend;
    }

    public boolean isTeleportAfterContractRegionBought() {
        return isTeleportAfterContractRegionBought;
    }

    public boolean isSendContractRegionExtendMessage() {
        return isSendContractRegionExtendMessage;
    }

    public String getDateTimeformat() {
        return DATE_TIMEFORMAT;
    }

    public boolean isRegionInfoParticleBorder() {
        return isRegionInfoParticleBorder;
    }

    public boolean isDeleteSubregionsOnParentRegionUnsell() {
        return deleteSubregionsOnParentRegionUnsell;
    }

    public boolean isDeleteSubregionsOnParentRegionBlockReset() {
        return deleteSubregionsOnParentRegionBlockReset;
    }

    public boolean isAllowTeleportToBuySign() {
        return isAllowTeleportToBuySign;
    }

    public boolean isAllowParentRegionOwnersBuildOnSubregions() {
        return allowParentRegionOwnersBuildOnSubregions;
    }

    public boolean isRemoveEntitiesOnRegionBlockReset() {
        return this.removeEntitiesOnRegionBlockReset;
    }

    public String getSignRightClickSneakCommand() {
        return signRightClickSneakCommand;
    }

    public String getSignRightClickNotSneakCommand() {
        return signRightClickNotSneakCommand;
    }

    public String getSignLeftClickSneakCommand() {
        return signLeftClickSneakCommand;
    }

    public String getSignLeftClickNotSneakCommand() {
        return signLeftClickNotSneakCommand;
    }


    /*#####################################
    ############### Setter ################
    #####################################*/

    public void setSubRegionPaybackPercentage(int subRegionPaybackPercentage) {
        this.subRegionPaybackPercentage = subRegionPaybackPercentage;
    }

    public void setCreateBackupOnRegionUnsell(boolean createBackupOnRegionUnsell) {
        this.createBackupOnRegionUnsell = createBackupOnRegionUnsell;
    }

    public void setMaxSubRegionMembers(int maxSubRegionMembers) {
        this.maxSubRegionMembers = maxSubRegionMembers;
    }

    public void setCreateBackupOnRegionRestore(boolean createBackupOnRegionRestore) {
        this.createBackupOnRegionRestore = createBackupOnRegionRestore;
    }

    public void setDateTimeformat(String dateTimeformat) {
        DATE_TIMEFORMAT = dateTimeformat;
    }

    public void setDeleteSubregionsOnParentRegionUnsell(boolean deleteSubregionsOnParentRegionUnsell) {
        this.deleteSubregionsOnParentRegionUnsell = deleteSubregionsOnParentRegionUnsell;
    }

    public void setDeleteSubregionsOnParentRegionBlockReset(boolean deleteSubregionsOnParentRegionBlockReset) {
        this.deleteSubregionsOnParentRegionBlockReset = deleteSubregionsOnParentRegionBlockReset;
    }

    public void setRemoveEntitiesOnRegionBlockReset(boolean removeEntitiesOnRegionReset) {
        this.removeEntitiesOnRegionBlockReset = removeEntitiesOnRegionReset;
    }

    public void setAllowParentRegionOwnersBuildOnSubregions(boolean allowParentRegionOwnersBuildOnSubregions) {
        this.allowParentRegionOwnersBuildOnSubregions = allowParentRegionOwnersBuildOnSubregions;
    }

    public void setSignRightClickNotSneakCommand(String signRightClickNotSneakCommand) {
        this.signRightClickNotSneakCommand = signRightClickNotSneakCommand;
    }

    public void setSignRightClickSneakCommand(String signRightClickSneakCommand) {
        this.signRightClickSneakCommand = signRightClickSneakCommand;
    }

    public void setSignLeftClickNotSneakCommand(String signLeftClickNotSneakCommand) {
        this.signLeftClickNotSneakCommand = signLeftClickNotSneakCommand;
    }

    public void setSignLeftClickSneakCommand(String signLeftClickSneakCommand) {
        this.signLeftClickSneakCommand = signLeftClickSneakCommand;
    }

    public long getUserResetCooldown() {
        return userResetCooldown;
    }

    public void setUserResetCooldown(long userResetCooldown) {
        this.userResetCooldown = userResetCooldown;
    }

    public void setActivateRegionKindPermissions(boolean activateRegionKindPermissions) {
        this.activateRegionKindPermissions = activateRegionKindPermissions;
    }

    public void setIsAllowTeleportToBuySign(boolean isAllowTeleportToBuySign) {
        this.isAllowTeleportToBuySign = isAllowTeleportToBuySign;
    }

    public void setIsAllowSubregionUserRestore(boolean isAllowSubRegionUserRestore) {
        this.isAllowSubRegionUserRestore = isAllowSubRegionUserRestore;
    }

    public void setIsRegionInfoParticleBorder(boolean isRegionInfoParticleBorder) {
        this.isRegionInfoParticleBorder = isRegionInfoParticleBorder;
    }

    public void setIsSubregionAutoRestore(boolean isSubregionAutoRestore) {
        this.isSubregionAutoRestore = isSubregionAutoRestore;
    }

    public void setIsSubregionInactivityReset(boolean isSubregionInactivityReset) {
        this.isSubregionInactivityReset = isSubregionInactivityReset;
    }

    public void setIsTeleportAfterSellRegionBought(boolean isTeleportAfterSellRegionBought) {
        this.isTeleportAfterSellRegionBought = isTeleportAfterSellRegionBought;
    }

    public void setIsTeleportAfterRentRegionBought(boolean teleportAfterRentRegionBought) {
        this.teleportAfterRentRegionBought = teleportAfterRentRegionBought;
    }

    public void setIsTeleportAfterRentRegionExtend(boolean isTeleportAfterRentRegionExtend) {
        this.isTeleportAfterRentRegionExtend = isTeleportAfterRentRegionExtend;
    }

    public void setIsTeleportAfterContractRegionBought(boolean isTeleportAfterContractRegionBought) {
        this.isTeleportAfterContractRegionBought = isTeleportAfterContractRegionBought;
    }

    public void setIsSendContractRegionExtendMessage(boolean isSendContractRegionExtendMessage) {
        this.isSendContractRegionExtendMessage = isSendContractRegionExtendMessage;
    }

}
