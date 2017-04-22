package alexanders.mods.skyutil;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import squeek.asmhelper.alexanders.mods.skyutil.ObfHelper;

import java.util.Map;

import static alexanders.mods.skyutil.Reference.MODNAME;

@IFMLLoadingPlugin.SortingIndex (1111)
@IFMLLoadingPlugin.TransformerExclusions ({"alexanders.mods.skyutil", "squeek.asmhelper"})
@IFMLLoadingPlugin.Name (MODNAME)
@IFMLLoadingPlugin.MCVersion ("1.10.2")
public class SkyUtilPlugin implements IFMLLoadingPlugin
{
    @Override
    public String[] getASMTransformerClass()
    {
        return new String[]{"alexanders.mods.skyutil.SkyUtilClassTransformer"};
    }

    @Override
    public String getModContainerClass()
    {
        return null;//"alexanders.mods.skyutil.SkyUtilMod";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
        ObfHelper.setObfuscated((Boolean) data.get("runtimeDeobfuscationEnabled"));
        ObfHelper.setRunsAfterDeobfRemapper(true);
    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}
