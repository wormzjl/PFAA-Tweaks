package pfaatweaks.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.*;

public class LSTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("fiskfille.lightsabers.common.generator.WorldGeneratorOres")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("generate")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.ALOAD, 4);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/world/World", "field_73011_w", "Lnet/minecraft/world/WorldProvider;");
                    mn.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/world/WorldProvider", "field_76574_g", "I");
                    Label l1 = new Label();
                    Label l2 = new Label();
                    Label l3 = new Label();
                    mn.visitTableSwitchInsn(18, 19, l3, new Label[] { l1, l2 });
                    mn.visitLabel(l1);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitVarInsn(Opcodes.ALOAD, 4);
                    mn.visitVarInsn(Opcodes.ALOAD, 1);
                    mn.visitVarInsn(Opcodes.ILOAD, 2);
                    mn.visitIntInsn(Opcodes.BIPUSH, 16);
                    mn.visitInsn(Opcodes.IMUL);
                    mn.visitVarInsn(Opcodes.ILOAD, 3);
                    mn.visitIntInsn(Opcodes.BIPUSH, 16);
                    mn.visitInsn(Opcodes.IMUL);
                    mn.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "fiskfille/lightsabers/common/generator/WorldGeneratorOres", "generateOverworld", "(Lnet/minecraft/world/World;Ljava/util/Random;II)V", false);
                    Label l4 = new Label();
                    mn.visitLabel(l4);
                    mn.visitJumpInsn(Opcodes.GOTO, l3);
                    mn.visitLabel(l2);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitVarInsn(Opcodes.ALOAD, 4);
                    mn.visitVarInsn(Opcodes.ALOAD, 1);
                    mn.visitVarInsn(Opcodes.ILOAD, 2);
                    mn.visitIntInsn(Opcodes.BIPUSH, 16);
                    mn.visitInsn(Opcodes.IMUL);
                    mn.visitVarInsn(Opcodes.ILOAD, 3);
                    mn.visitIntInsn(Opcodes.BIPUSH, 16);
                    mn.visitInsn(Opcodes.IMUL);
                    mn.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "fiskfille/lightsabers/common/generator/WorldGeneratorOres", "generateOverworld", "(Lnet/minecraft/world/World;Ljava/util/Random;II)V", false);
                    mn.visitLabel(l3);
                    mn.visitInsn(Opcodes.RETURN);
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("fiskfille.lightsabers.common.generator.WorldGeneratorStructures")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("generate")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.ALOAD, 4);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/world/World", "field_73011_w", "Lnet/minecraft/world/WorldProvider;");
                    mn.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/world/WorldProvider", "field_76574_g", "I");
                    Label l1 = new Label();
                    Label l2 = new Label();
                    Label l3 = new Label();
                    mn.visitTableSwitchInsn(18, 19, l3, new Label[] { l1, l2 });
                    mn.visitLabel(l1);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitVarInsn(Opcodes.ALOAD, 4);
                    mn.visitVarInsn(Opcodes.ALOAD, 1);
                    mn.visitVarInsn(Opcodes.ILOAD, 2);
                    mn.visitIntInsn(Opcodes.BIPUSH, 16);
                    mn.visitInsn(Opcodes.IMUL);
                    mn.visitVarInsn(Opcodes.ILOAD, 3);
                    mn.visitIntInsn(Opcodes.BIPUSH, 16);
                    mn.visitInsn(Opcodes.IMUL);
                    mn.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "fiskfille/lightsabers/common/generator/WorldGeneratorStructures", "generateOverworld", "(Lnet/minecraft/world/World;Ljava/util/Random;II)V", false);
                    Label l4 = new Label();
                    mn.visitLabel(l4);
                    mn.visitJumpInsn(Opcodes.GOTO, l3);
                    mn.visitLabel(l2);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitVarInsn(Opcodes.ALOAD, 4);
                    mn.visitVarInsn(Opcodes.ALOAD, 1);
                    mn.visitVarInsn(Opcodes.ILOAD, 2);
                    mn.visitIntInsn(Opcodes.BIPUSH, 16);
                    mn.visitInsn(Opcodes.IMUL);
                    mn.visitVarInsn(Opcodes.ILOAD, 3);
                    mn.visitIntInsn(Opcodes.BIPUSH, 16);
                    mn.visitInsn(Opcodes.IMUL);
                    mn.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "fiskfille/lightsabers/common/generator/WorldGeneratorStructures", "generateOverworld", "(Lnet/minecraft/world/World;Ljava/util/Random;II)V", false);
                    mn.visitLabel(l3);
                    mn.visitInsn(Opcodes.RETURN);
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("fiskfille.lightsabers.common.item.ItemLightsaberBase")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("getAttackDamage")) {
                        mn.instructions.clear();
                        mn.instructions.add(new LdcInsnNode(1200.0D));
                        mn.instructions.add(new InsnNode(Opcodes.DRETURN));
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("fiskfille.lightsabers.common.generator.structure.EnumStructure")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<clinit>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    AbstractInsnNode n1 = null;
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.BIPUSH && ((IntInsnNode) n).operand == 8) {
                            n1 = n;
                        } else if (n.getOpcode() == Opcodes.BIPUSH && ((IntInsnNode) n).operand == 16) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n1, new IntInsnNode(Opcodes.BIPUSH, 16));
                        mn.instructions.set(n, new IntInsnNode(Opcodes.BIPUSH, 32));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else {
            return bytes;
        }
    }
}
