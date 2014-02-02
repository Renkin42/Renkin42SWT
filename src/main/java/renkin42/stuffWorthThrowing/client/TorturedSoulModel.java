// Date: 6/10/2013 10:23:33 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package renkin42.stuffWorthThrowing.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class TorturedSoulModel extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer leftWing;
    ModelRenderer rightWing;
  
  public TorturedSoulModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-8F, -12F, -16F, 16, 16, 16);
      head.setRotationPoint(0F, 4F, 8F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      tail1 = new ModelRenderer(this, 0, 32);
      tail1.addBox(-4F, -4F, -0.5F, 8, 8, 8);
      tail1.setRotationPoint(0F, 4F, 8F);
      tail1.setTextureSize(64, 64);
      tail1.mirror = true;
      setRotation(tail1, 0.0872665F, 0F, 0F);
      tail2 = new ModelRenderer(this, 0, 48);
      tail2.addBox(-2F, 0F, 7F, 4, 4, 8);
      tail2.setRotationPoint(0F, 4F, 8F);
      tail2.setTextureSize(64, 64);
      tail2.mirror = true;
      setRotation(tail2, 0.2617994F, 0F, 0F);
      leftWing = new ModelRenderer(this, 32, 32);
      leftWing.addBox(-1F, 0F, -6F, 1, 12, 12);
      leftWing.setRotationPoint(-8F, -2F, 0F);
      leftWing.setTextureSize(64, 64);
      leftWing.mirror = true;
      setRotation(leftWing, 0F, 0F, 0.0872665F);
      rightWing = new ModelRenderer(this, 32, 32);
      rightWing.addBox(0F, 0F, -6F, 1, 12, 12);
      rightWing.setRotationPoint(8F, -2F, 0F);
      rightWing.setTextureSize(64, 64);
      rightWing.mirror = true;
      setRotation(rightWing, 0F, 0F, -0.0872665F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    tail1.render(f5);
    tail2.render(f5);
    leftWing.render(f5);
    rightWing.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    tail1.rotateAngleY = MathHelper.cos(f) * 0.0872665F;
    tail2.rotateAngleY = MathHelper.cos(f) * 0.2617994F;
    leftWing.rotateAngleZ = MathHelper.cos(f) * 0.0872665F + 0.0872665F + f1;
    rightWing.rotateAngleZ = MathHelper.cos(f + (float)Math.PI) * 0.0872665F - 0.0872665F - f1;
  }

}
