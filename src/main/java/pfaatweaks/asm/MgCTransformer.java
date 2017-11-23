package pfaatweaks.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class MgCTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("com.cout970.magneticraft.ManagerFluids")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("registerFuels")) {
                    mn.instructions.clear();
                    mn.instructions.add(new InsnNode(Opcodes.RETURN));
                } else if (mn.name.equals("registerBCFuels")) {
                    mn.instructions.clear();
                    mn.instructions.add(new InsnNode(Opcodes.RETURN));
                } else if (mn.name.equals("registerIEFuels")) {
                    mn.instructions.clear();
                    mn.instructions.add(new InsnNode(Opcodes.RETURN));
                } else if (mn.name.equals("registerRCFuels")) {
                    mn.instructions.clear();
                    mn.instructions.add(new InsnNode(Opcodes.RETURN));
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("com.cout970.magneticraft.tileentity.TileBoiler")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("func_145845_h")) {
                    mn.instructions.clear();
                    mn.instructions.add(new InsnNode(Opcodes.RETURN));
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            return cw.toByteArray();        
        } else if (name.equals("com.cout970.magneticraft.tileentity.multiblock.controllers.TileCrusher")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("func_145845_h")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    AbstractInsnNode n1 = null;
                    AbstractInsnNode n2 = null;
                    AbstractInsnNode n3 = null;
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(10.0D)) {
                            if (n.getNext().getNext().getOpcode() == Opcodes.DSTORE && ((VarInsnNode) n.getNext().getNext()).var==1) {
                                n1 = n;
                            } else if (n.getNext().getNext().getNext().getOpcode() == Opcodes.D2F) {
                                n2 = n;
                            } else if (n.getNext().getNext().getNext().getOpcode() == Opcodes.INVOKEVIRTUAL) {
                                n3 = n;
                                break;
                            }
                        }
                        n = n.getNext();
                    }
                    if (n1 != null) {
                        mn.instructions.set(n1, new LdcInsnNode(0.5D));
                        mn.instructions.set(n2, new LdcInsnNode(200.0D));
                        mn.instructions.set(n3, new LdcInsnNode(800.0D));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("com.cout970.magneticraft.tileentity.multiblock.controllers.TileGrinder")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("func_145845_h")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    AbstractInsnNode n1 = null;
                    AbstractInsnNode n2 = null;
                    AbstractInsnNode n3 = null;
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(10.0D)) {
                            if (n.getNext().getNext().getOpcode() == Opcodes.DSTORE && ((VarInsnNode) n.getNext().getNext()).var==1) {
                                n1 = n;
                            } else if (n.getNext().getNext().getNext().getOpcode() == Opcodes.D2F) {
                                n2 = n;
                            } else if (n.getNext().getNext().getNext().getOpcode() == Opcodes.INVOKEVIRTUAL) {
                                n3 = n;
                                break;
                            }
                        }
                        n = n.getNext();
                    }
                    if (n1 != null) {
                        mn.instructions.set(n1, new LdcInsnNode(0.5D));
                        mn.instructions.set(n2, new LdcInsnNode(200.0D));
                        mn.instructions.set(n3, new LdcInsnNode(800.0D));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("com.cout970.magneticraft.tileentity.multiblock.controllers.TileSifter")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("func_145845_h")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(100.0F)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(400.0F));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("com.cout970.magneticraft.api.util.EnergyConverter")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("RFtoW")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.DLOAD, 0);
                    mn.visitLdcInsn(2.0D);
                    mn.visitInsn(Opcodes.DMUL);
                    mn.visitInsn(Opcodes.DRETURN);
                    mn.visitEnd();
                } else if (mn.name.equals("WtoRF")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.DLOAD, 0);
                    mn.visitLdcInsn(2.0D);
                    mn.visitInsn(Opcodes.DDIV);
                    mn.visitInsn(Opcodes.DRETURN);
                    mn.visitEnd();
                } else if (mn.name.equals("WtoSTEAM")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.DLOAD, 0);
                    mn.visitLdcInsn(4.0D);
                    mn.visitInsn(Opcodes.DDIV);
                    mn.visitInsn(Opcodes.DRETURN);
                    mn.visitEnd();
                } else if (mn.name.equals("STEAMtoW")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.DLOAD, 0);
                    mn.visitLdcInsn(4.0D);
                    mn.visitInsn(Opcodes.DMUL);
                    mn.visitInsn(Opcodes.DRETURN);
                    mn.visitEnd();
                } else if (mn.name.equals("FUELtoW")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.DLOAD, 0);
                    mn.visitLdcInsn(20.0D);
                    mn.visitInsn(Opcodes.DMUL);
                    mn.visitInsn(Opcodes.DRETURN);
                } else if (mn.name.equals("WtoFUEL")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.DLOAD, 0);
                    mn.visitLdcInsn(20.0D);
                    mn.visitInsn(Opcodes.DDIV);
                    mn.visitInsn(Opcodes.DRETURN);
                } else if (mn.name.equals("EUtoW")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.DLOAD, 0);
                    mn.visitLdcInsn(8.0D);
                    mn.visitInsn(Opcodes.DMUL);
                    mn.visitInsn(Opcodes.DRETURN);
                } else if (mn.name.equals("WtoEU")) {
                    mn.instructions.clear();
                    mn.visitVarInsn(Opcodes.DLOAD, 0);
                    mn.visitLdcInsn(8.0D);
                    mn.visitInsn(Opcodes.DDIV);
                    mn.visitInsn(Opcodes.DRETURN);
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            return cw.toByteArray();        
        } else {
            return bytes;
        }
    }
}
