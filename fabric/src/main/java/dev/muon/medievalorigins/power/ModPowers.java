package dev.muon.medievalorigins.power;

import dev.muon.medievalorigins.MedievalOrigins;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.power.factory.PowerFactorySupplier;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.origins.Origins;
import io.github.apace100.origins.power.OriginsCallbackPower;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;

public class ModPowers {
    public static void register() {
        if (FabricLoader.getInstance().isModLoaded("icarus")) {
            registerPowerFactory(IcarusWingsPower.ICARUS_WINGS_FACTORY);
        }
        register(OwnerAttributeTransferPower.createFactory());
    }
    public static void registerPowerFactory(PowerFactory<?> serializer) {
        Registry.register(ApoliRegistries.POWER_FACTORY, serializer.getSerializerId(), serializer);
    }
    public static void registerPowerFactorySupplier(PowerFactorySupplier<?> supplier) {
        registerPowerFactory(supplier.createFactory());
    }

    private static void register(PowerFactory<?> serializer) {
        Registry.register(ApoliRegistries.POWER_FACTORY, serializer.getSerializerId(), serializer);
    }

    private static void register(PowerFactorySupplier<?> supplier) {
        register(supplier.createFactory());
    }

}
