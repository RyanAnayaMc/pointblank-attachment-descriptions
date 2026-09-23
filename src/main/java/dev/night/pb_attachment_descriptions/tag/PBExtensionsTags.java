package dev.night.pb_attachment_descriptions.tag;

import dev.night.pb_attachment_descriptions.PBAttachmentDescriptionsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PBExtensionsTags {
    public static class Items {

    }

    private static TagKey<Item> create(String tag) {
        return create(PBAttachmentDescriptionsMod.MODID, tag);
    }

    private static TagKey<Item> create(String namespace, String tag) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, tag));
    }
}
