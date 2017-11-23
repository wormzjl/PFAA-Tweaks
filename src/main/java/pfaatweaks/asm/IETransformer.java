package pfaatweaks.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.*;

public class IETransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("blusunrize.immersiveengineering.common.blocks.wooden.TileEntityWatermill")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("getPower")) {
                    mn.instructions.clear();
                    mn.visitLdcInsn(0.2D);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "blusunrize/immersiveengineering/common/blocks/wooden/TileEntityWatermill", "facing", "I");
                    mn.visitInsn(Opcodes.ICONST_3);
                    Label LabelJ1= new Label();
                    mn.visitJumpInsn(Opcodes.IF_ICMPGT, LabelJ1);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "blusunrize/immersiveengineering/common/blocks/wooden/TileEntityWatermill", "getRotationVec", "()Lnet/minecraft/util/Vec3;", false);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/util/Vec3", "field_72450_a", "D");
                    mn.visitInsn(Opcodes.DNEG);
                    Label LabelJ2= new Label();
                    mn.visitJumpInsn(Opcodes.GOTO, LabelJ2);
                    mn.visitLabel(LabelJ1);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "blusunrize/immersiveengineering/common/blocks/wooden/TileEntityWatermill", "getRotationVec", "()Lnet/minecraft/util/Vec3;", false);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/util/Vec3", "field_72449_c", "D");
                    mn.visitLabel(LabelJ2);
                    mn.visitInsn(Opcodes.DMUL);
                    mn.visitInsn(Opcodes.DRETURN);
                    mn.visitEnd();
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("blusunrize.immersiveengineering.common.blocks.wooden.TileEntityWindmill")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("func_145845_h")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(5.0E-5D)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(5.0E-6D));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("blusunrize.immersiveengineering.common.blocks.metal.TileEntitySheetmetalTank")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(512000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(1024000));
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
