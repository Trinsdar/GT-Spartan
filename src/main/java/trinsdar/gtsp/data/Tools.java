package trinsdar.gtsp.data;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.WeaponTraits;
import com.oblivioussp.spartanweaponry.init.ModItems;
import com.oblivioussp.spartanweaponry.util.WeaponArchetype;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterDefaultTools;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.registration.IAntimatterObject;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.behaviour.BehaviourLogStripping;
import muramasa.antimatter.tool.behaviour.BehaviourTreeFelling;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import trinsdar.gtsp.GTSPRef;
import trinsdar.gtsp.items.MaterialSwordSpartan;
import trinsdar.gtsp.tool.GTSPToolType;

import java.util.List;
import java.util.Map;


public class Tools {

    private static final List<AntimatterToolType> tools = new ObjectArrayList<>();

    public static AntimatterToolType DAGGER = register(new GTSPToolType(GTSPRef.ID, "dagger", 2.5f, 1.0f, -1.5f, WeaponArchetype.DAGGER));
    public static AntimatterToolType PARRYING_DAGGER = register(new GTSPToolType(GTSPRef.ID, "parrying_dagger", 2.5f, 1.0f, -1.5f, WeaponArchetype.PARRYING_DAGGER));
    public static AntimatterToolType LONGSWORD = register(new GTSPToolType(GTSPRef.ID, "longsword", 4.5f, 1.5f, -2.6f, WeaponArchetype.LONGSWORD));
    public static AntimatterToolType KATANA = register(new GTSPToolType(GTSPRef.ID, "katana", 3.5f, 0.5f, -2.0f, WeaponArchetype.KATANA));
    public static AntimatterToolType SABER = register(new GTSPToolType(GTSPRef.ID, "saber", 3.5f, 0.5f, -1.6f, WeaponArchetype.SABER));
    public static AntimatterToolType RAPIER = register(new GTSPToolType(GTSPRef.ID, "rapier", 2.0f, 0.5f, -1.5f, WeaponArchetype.RAPIER));
    public static AntimatterToolType GREATSWORD = register(new GTSPToolType(GTSPRef.ID, "greatsword", 4.0f, 1.5f, -2.6f, WeaponArchetype.GREATSWORD));
    public static AntimatterToolType BATTLE_HAMMER = register(new GTSPToolType(GTSPRef.ID, "battle_hammer", 5.0f, 2.0f, -3.2f, WeaponArchetype.BATTLE_HAMMER));
    public static AntimatterToolType WARHAMMER = register(new GTSPToolType(GTSPRef.ID, "warhammer", 4.0f, 1.5f, -2.9f, WeaponArchetype.WARHAMMER));
    public static AntimatterToolType SPEAR = register(new GTSPToolType(GTSPRef.ID, "spear", 5.5f, 0.5f, -2.6f, WeaponArchetype.SPEAR));
    public static AntimatterToolType HALBERD = register(new GTSPToolType(GTSPRef.ID, "halberd", 5.0f, 1.5f, -2.8f, WeaponArchetype.HALBERD));
    public static AntimatterToolType PIKE = register(new GTSPToolType(GTSPRef.ID, "pike", 4.0f, 1.0f, -3f, WeaponArchetype.PIKE));
    public static AntimatterToolType LANCE = register(new GTSPToolType(GTSPRef.ID, "lance", 4.0f, 1.0f, -3f, WeaponArchetype.LANCE));
    //TODO:
    /**  Longbow
     *   Heavy Crossbow
     *   Throwing Knife
     *   Tomahawk
     *   Javelin
     *   Boomerang
     * */
    public static AntimatterToolType BATTLEAXE = register(new GTSPToolType(GTSPRef.ID, "battleaxe", 4.0f, 2.0f, -3f, WeaponArchetype.BATTLEAXE));
    public static AntimatterToolType FLANGED_MACE = register(new GTSPToolType(GTSPRef.ID, "flanged_mace", 3.0f, 1.5f, -2.8f, WeaponArchetype.FLANGED_MACE));
    public static AntimatterToolType GLAIVE = register(new GTSPToolType(GTSPRef.ID, "glaive", 4.0f, 1.5f, -3f, WeaponArchetype.GLAIVE));
    public static AntimatterToolType QUARTERSTAFF = register(new GTSPToolType(GTSPRef.ID, "quarterstaff", 3.0f, 1.5f, -2.6f, WeaponArchetype.QUARTERSTAFF));





    public static void init(){
        BATTLEAXE.addBehaviour(BehaviourLogStripping.INSTANCE, BehaviourTreeFelling.INSTANCE);
        AntimatterDefaultTools.SCYTHE.setOverlayLayers(2).setToolSupplier((domain2, toolType, tier, properties) -> {
            if (tier.getPrimary() == AntimatterMaterials.NetherizedDiamond) properties.fireResistant();
            return new MaterialSwordSpartan(domain2, toolType, tier, properties, WeaponArchetype.SCYTHE, 1.0f);
        }).setUseDurability(1).setAttackDurability(1).setBaseAttackDamage(5.0f).setBaseAttackSpeed(-3.0f);
        tools.add(AntimatterDefaultTools.SCYTHE);
        tools.forEach(t -> {
            t.addReplacement(AntimatterMaterials.Iron, () -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "iron_" + t.getId())));
            t.addReplacement(AntimatterMaterials.Gold, () -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "golden_" + t.getId())));
            t.addReplacement(AntimatterMaterials.Diamond, () -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(SpartanWeaponryAPI.MOD_ID, "diamond_" + t.getId())));
        });
    }

    private static AntimatterToolType register(@NotNull AntimatterToolType toolType){
        toolType = AntimatterAPI.register(AntimatterToolType.class, toolType);
        tools.add(toolType);
        return toolType;
    }
}
