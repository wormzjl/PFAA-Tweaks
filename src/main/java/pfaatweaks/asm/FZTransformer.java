package pfaatweaks.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class FZTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("factorization.beauty.TileEntitySteamShaft")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("func_145845_h")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals("steam")) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode("fzsteam"));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("factorization.charge.TileEntitySolarBoiler")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("setupSteam")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals("steam")) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode("fzsteam"));
                    }
                } else if (mn.name.equals("putData")) {
                    AbstractInsnNode n1 = mn.instructions.getFirst();
                    while (n1 != null) {
                        if (n1.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n1).cst.equals("steam")) {
                            break;
                        }
                        n1 = n1.getNext();
                    }
                    if (n1 != null) {
                        mn.instructions.set(n1, new LdcInsnNode("fzsteam"));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("factorization.beauty.TileEntitySteamTurbine")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("func_145845_h")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals("steam")) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode("fzsteam"));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("factorization.common.Registry")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("makeItems")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals("steam")) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode("fzsteam"));
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
