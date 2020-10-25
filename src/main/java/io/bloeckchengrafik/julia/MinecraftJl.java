package io.bloeckchengrafik.julia;

import io.bloeckchengrafik.julia.threaded.ThreadedHTTPServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MinecraftJl.MODID, name = MinecraftJl.NAME, version = MinecraftJl.VERSION)
public class MinecraftJl
{
    public ThreadedHTTPServer httpServer;

    public static final String MODID = "minecraft.jl";
    public static final String NAME = "Julia-Hook";
    public static final String VERSION = "1.0";

    public static Logger logger;
    private static MinecraftJl minecraftJl;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        minecraftJl = this;
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.warn("*------------------------------*");
        logger.warn("*         ~Welcome to~         *");
        logger.warn("*        _       _ _(_)_       *");
        logger.warn("*       (_)     | (_) (_)      *");
        logger.warn("*        _ _   _| |_  __ _     *");
        logger.warn("*       | | | | | | |/ _` |    *");
        logger.warn("*       | | |_| | | | (_| |    *");
        logger.warn("*      _/ |\\__'_|_|_|\\__'_|    *");
        logger.warn("*     |__/                     *");
        logger.warn("*------------------------------*");

        httpServer = new ThreadedHTTPServer();
        httpServer.start();

    }

    public static MinecraftJl getInstance() {
        return minecraftJl;
    }
}
