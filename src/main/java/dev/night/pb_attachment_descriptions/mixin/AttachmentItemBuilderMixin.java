package dev.night.pb_attachment_descriptions.mixin;

import com.google.gson.JsonObject;
import com.vicmatskiv.pointblank.item.AttachmentItem;
import com.vicmatskiv.pointblank.util.JsonUtil;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AttachmentItem.Builder.class)
public abstract class AttachmentItemBuilderMixin {
    @Shadow
    public abstract AttachmentItem.Builder withDescription(Component description);

    @Shadow
    public abstract AttachmentItem.Builder withDescription(String description);

    @Inject(method = "withJsonObject(Lcom/google/gson/JsonObject;Z)Lcom/vicmatskiv/pointblank/item/AttachmentItem$Builder;", at = @At(value = "HEAD"))
    public void fromJSON(JsonObject obj, boolean isClientSide, CallbackInfoReturnable<AttachmentItem.Builder> cir) {
        for (JsonObject descriptionObject : JsonUtil.getJsonObjects(obj, "description")) {
            if (descriptionObject != null) {
                String translationKey = JsonUtil.getJsonString(descriptionObject, "desc");
                int color = JsonUtil.getJsonInt(descriptionObject, "color", 16733525);
                this.withDescription(Component.translatable(translationKey).withColor(color));
            }
        }
    }
}
