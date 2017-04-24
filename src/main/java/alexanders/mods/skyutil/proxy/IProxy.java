package alexanders.mods.skyutil.proxy;

import alexanders.mods.skyutil.item.SUItem;

public interface IProxy
{
    void registerItem(SUItem item);

    void registerItemRender(SUItem item);
}
