package pfaatweaks.asm;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class TGTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("techguns.damagesystem.DamageSystem")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("getDamageFactor")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.FCONST_1) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(35.0F));
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
