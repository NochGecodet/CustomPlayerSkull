public static ItemStack gethead(String name,String[] lores,String url){
        List<String> lore = new ArrayList<>();
        ItemStack head = new ItemStack(Material.SKULL_ITEM,1, (short) 3);
        SkullMeta headM = (SkullMeta) head.getItemMeta();
        headM.setDisplayName(name);
        lore.addAll(Arrays.asList(lores));
        headM.setLore(lore);
        GameProfile profile = new GameProfile(UUID.randomUUID(),null);
        profile.getProperties().put("textures",new Property("textures",url));
        try {
        Field profileField = headM.getClass().getDeclaredField("profile");
        profileField.setAccessible(true);
        profileField.set(headM,profile);
        } catch (NoSuchFieldException | IllegalAccessException e) {
        e.printStackTrace();
        }
        head.setItemMeta(headM);
        return head;
        }