package pfaatweaks.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class MOTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("matteroverdrive.items.weapon.IonSniper")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("getWeaponBaseDamage")) {
                        mn.instructions.clear();
                        mn.instructions.add(new LdcInsnNode(2000.0F));
                        mn.instructions.add(new InsnNode(Opcodes.FRETURN));
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("matteroverdrive.items.weapon.OmniTool")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("getWeaponBaseDamage")) {
                        mn.instructions.clear();
                        mn.instructions.add(new LdcInsnNode(150.0F));
                        mn.instructions.add(new InsnNode(Opcodes.FRETURN));
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("matteroverdrive.items.weapon.PhaserRifle")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("getWeaponBaseDamage")) {
                        mn.instructions.clear();
                        mn.instructions.add(new LdcInsnNode(1000.0F));
                        mn.instructions.add(new InsnNode(Opcodes.FRETURN));
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("matteroverdrive.items.weapon.PlasmaShotgun")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("getWeaponBaseDamage")) {
                        mn.instructions.clear();
                        mn.instructions.add(new LdcInsnNode(1200.0F));
                        mn.instructions.add(new InsnNode(Opcodes.FRETURN));
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("matteroverdrive.entity.monster.EntityRougeAndroidMob")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("init")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    AbstractInsnNode n1 = null;
                    AbstractInsnNode n2 = null;
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(128.0D)) {
                            n1=n;
                        } else if (n.getOpcode() == Opcodes.BIPUSH && ((IntInsnNode) n).operand == 10) {
                            n2=n;
                        } else if (n.getOpcode() == Opcodes.BIPUSH && ((IntInsnNode) n).operand == 32) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n1 != null) {
                        mn.instructions.set(n1, new LdcInsnNode(1024.0D));
                        mn.instructions.set(n2, new IntInsnNode(Opcodes.SIPUSH, 128));
                        mn.instructions.set(n, new IntInsnNode(Opcodes.SIPUSH, 512));
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
