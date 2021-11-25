// サーバー側から送信されるパケットのヘッダの定義
package packet;

public class InPacket {

    public enum Header {
        PING,
        LOGIN_STATUS,
        SERVERLIST,
        CHARLIST,
        SERVER_IP,
        CHAR_NAME_RESPONSE,
        ADD_NEW_CHAR_ENTRY,
        DELETE_CHAR_RESPONSE,
        CHANGE_CHANNEL,
        SECONDPW_ERROR,
        LOGIN_AUTH,
        MODIFY_INVENTORY_ITEM,
        UPDATE_INVENTORY_SLOT,
        UPDATE_STATS,
        GIVE_BUFF,
        CANCEL_BUFF,
        TEMP_STATS,
        TEMP_STATS_RESET,
        UPDATE_SKILLS,
        FAME_RESPONSE,
        SHOW_STATUS_INFO,
        SHOW_NOTES,
        TROCK_LOCATIONS,
        UPDATE_MOUNT,
        SHOW_QUEST_COMPLETION,
        SEND_TITLE_BOX,
        USE_SKILL_BOOK,
        FINISH_SORT,
        FINISH_GATHER,
        CHAR_INFO,
        PARTY_OPERATION,
        EXPEDITION_OPERATION,
        BUDDYLIST,
        GUILD_OPERATION,
        ALLIANCE_OPERATION,
        SPAWN_PORTAL,
        SERVERMESSAGE,
        PIGMI_REWARD,
        OWL_OF_MINERVA,
        ENGAGE_REQUEST,
        ENGAGE_RESULT,
        YELLOW_CHAT,
        FISHING_BOARD_UPDATE,
        PLAYER_NPC,
        MONSTERBOOK_ADD,
        MONSTERBOOK_CHANGE_COVER,
        AVATAR_MEGA,
        ENERGY,
        GHOST_POINT,
        GHOST_STATUS,
        FAIRY_PEND_MSG,
        SEND_PEDIGREE,
        OPEN_FAMILY,
        FAMILY_MESSAGE,
        FAMILY_INVITE,
        FAMILY_JUNIOR,
        SENIOR_MESSAGE,
        FAMILY,
        REP_INCREASE,
        FAMILY_LOGGEDIN,
        FAMILY_BUFF,
        FAMILY_USE_REQUEST,
        LEVEL_UPDATE,
        MARRIAGE_UPDATE,
        JOB_UPDATE,
        FOLLOW_REQUEST,
        TOP_MSG,
        SKILL_MACRO,
        WARP_TO_MAP,
        MTS_OPEN,
        CS_OPEN,
        SERVER_BLOCKED,
        SHOW_EQUIP_EFFECT,
        MULTICHAT,
        WHISPER,
        BOSS_ENV,
        MOVE_ENV,
        UPDATE_ENV,
        MAP_EFFECT,
        CASH_SONG,
        GM_EFFECT,
        OX_QUIZ,
        GMEVENT_INSTRUCTIONS,
        CLOCK,
        BOAT_EFF,
        BOAT_EFFECT,
        STOP_CLOCK,
        PYRAMID_UPDATE,
        PYRAMID_RESULT,
        MOVE_PLATFORM,
        SPAWN_PLAYER,
        REMOVE_PLAYER_FROM_MAP,
        CHATTEXT,
        CHATTEXT1,
        CHALKBOARD,
        UPDATE_CHAR_BOX,
        SHOW_SCROLL_EFFECT,
        SHOW_POTENTIAL_RESET,
        SHOW_POTENTIAL_EFFECT,
        FISHING_CAUGHT,
        PAMS_SONG,
        FOLLOW_EFFECT,
        SPAWN_PET,
        MOVE_PET,
        PET_CHAT,
        PET_NAMECHANGE,
        PET_COMMAND,
        SPAWN_SUMMON,
        REMOVE_SUMMON,
        MOVE_SUMMON,
        SUMMON_ATTACK,
        SUMMON_SKILL,
        DAMAGE_SUMMON,
        DRAGON_SPAWN,
        DRAGON_MOVE,
        DRAGON_REMOVE,
        MOVE_PLAYER,
        CLOSE_RANGE_ATTACK,
        RANGED_ATTACK,
        MAGIC_ATTACK,
        ENERGY_ATTACK,
        SKILL_EFFECT,
        CANCEL_SKILL_EFFECT,
        DAMAGE_PLAYER,
        FACIAL_EXPRESSION,
        SHOW_ITEM_EFFECT,
        SHOW_CHAIR,
        UPDATE_CHAR_LOOK,
        SHOW_FOREIGN_EFFECT,
        GIVE_FOREIGN_BUFF,
        CANCEL_FOREIGN_BUFF,
        UPDATE_PARTYMEMBER_HP,
        LOAD_GUILD_NAME,
        LOAD_GUILD_ICON,
        CANCEL_CHAIR,
        SHOW_ITEM_GAIN_INCHAT,
        CURRENT_MAP_WARP,
        MESOBAG_SUCCESS,
        MESOBAG_FAILURE,
        RANDOM_MESOBAG_SUCCESS,
        RANDOM_MESOBAG_FAILURE,
        UPDATE_QUEST_INFO,
        PLAYER_HINT,
        REPAIR_WINDOW,
        CYGNUS_INTRO_LOCK,
        CYGNUS_INTRO_DISABLE_UI,
        SUMMON_HINT,
        SUMMON_HINT_MSG,
        ARAN_COMBO,
        TAMA_BOX_SUCCESS,
        TAMA_BOX_FAILURE,
        GAME_POLL_REPLY,
        FOLLOW_MESSAGE,
        FOLLOW_MOVE,
        FOLLOW_MSG,
        GAME_POLL_QUESTION,
        COOLDOWN,
        SPAWN_MONSTER,
        KILL_MONSTER,
        SPAWN_MONSTER_CONTROL,
        MOVE_MONSTER,
        MOVE_MONSTER_RESPONSE,
        APPLY_MONSTER_STATUS,
        CANCEL_MONSTER_STATUS,
        MOB_TO_MOB_DAMAGE,
        DAMAGE_MONSTER,
        SHOW_MONSTER_HP,
        SHOW_MAGNET,
        CATCH_MONSTER,
        MOB_SPEAKING,
        MONSTER_PROPERTIES,
        REMOVE_TALK_MONSTER,
        TALK_MONSTER,
        SPAWN_NPC,
        REMOVE_NPC,
        SPAWN_NPC_REQUEST_CONTROLLER,
        NPC_ACTION,
        SPAWN_HIRED_MERCHANT,
        DESTROY_HIRED_MERCHANT,
        UPDATE_HIRED_MERCHANT,
        DROP_ITEM_FROM_MAPOBJECT,
        REMOVE_ITEM_FROM_MAP,
        KITE_MESSAGE,
        SPAWN_KITE,
        REMOVE_KITE,
        SPAWN_MIST,
        REMOVE_MIST,
        SPAWN_DOOR,
        REMOVE_DOOR,
        REACTOR_HIT,
        REACTOR_SPAWN,
        REACTOR_DESTROY,
        ROLL_SNOWBALL,
        HIT_SNOWBALL,
        SNOWBALL_MESSAGE,
        LEFT_KNOCK_BACK,
        HIT_COCONUT,
        COCONUT_SCORE,
        MONSTER_CARNIVAL_START,
        MONSTER_CARNIVAL_OBTAINED_CP,
        MONSTER_CARNIVAL_PARTY_CP,
        MONSTER_CARNIVAL_SUMMON,
        MONSTER_CARNIVAL_DIED,
        CHAOS_HORNTAIL_SHRINE,
        CHAOS_ZAKUM_SHRINE,
        HORNTAIL_SHRINE,
        ZAKUM_SHRINE,
        NPC_TALK,
        OPEN_NPC_SHOP,
        CONFIRM_SHOP_TRANSACTION,
        OPEN_STORAGE,
        MERCH_ITEM_MSG,
        MERCH_ITEM_STORE,
        RPS_GAME,
        MESSENGER,
        PLAYER_INTERACTION,
        CS_UPDATE,
        CS_OPERATION,
        KEYMAP,
        PET_AUTO_HP,
        PET_AUTO_MP,
        GET_MTS_TOKENS,
        MTS_OPERATION,
        BLOCK_PORTAL,
        ARIANT_SCOREBOARD,
        ARIANT_THING,
        ARIANT_PQ_START,
        VICIOUS_HAMMER,
        REPORT_PLAYER_MSG,
        NPC_CONFIRM,
        UPDATE_BEANS,
        TIP_BEANS,
        OPEN_BEANS,
        SHOOT_BEANS;

        private int value;

        Header(int header) {
            value = header;
        }

        Header() {
            value = 0xFFFF;
        }

        public boolean Set(int header) {
            value = header;
            return true;
        }

        public int Get() {
            return value;
        }
    }

    // JMS v186.1 ProcessPacket
    public static void SetForJMSv186() {
        Header.LOGIN_STATUS.Set(0x0000);
        // 0x0001 SERVERSTATUS?
        Header.SERVERLIST.Set(0x0002);
        Header.CHARLIST.Set(0x0003);
        Header.SERVER_IP.Set(0x0004);
        Header.CHAR_NAME_RESPONSE.Set(0x0005);
        Header.ADD_NEW_CHAR_ENTRY.Set(0x0006);
        Header.DELETE_CHAR_RESPONSE.Set(0x0007);
        Header.CHANGE_CHANNEL.Set(0x0008);
        Header.PING.Set(0x0009);
        // 0x000A
        // 0x000B
        // 0x000C
        // 0x000D CHANNEL_SELECTED?
        // 0x000E
        // 0x000F RELOG_RESPONSE?
        // 0x0010
        // 0x0011
        // 0x0012
        // 0x0013
        // 0x0014
        // 0x0015
        Header.SECONDPW_ERROR.Set(0x0016);
        // 0x0017
        Header.LOGIN_AUTH.Set(0x0018);
        // 0x0019
        // 0x001A
        Header.MODIFY_INVENTORY_ITEM.Set(0x001B);
        Header.UPDATE_INVENTORY_SLOT.Set(0x001C);
        Header.UPDATE_STATS.Set(0x001D);
        Header.GIVE_BUFF.Set(0x001E);
        Header.CANCEL_BUFF.Set(0x001F);
        Header.TEMP_STATS.Set(0x0020);
        Header.TEMP_STATS_RESET.Set(0x0021);
        Header.UPDATE_SKILLS.Set(0x0022);
        // 0x0023
        Header.FAME_RESPONSE.Set(0x0024);
        Header.SHOW_STATUS_INFO.Set(0x0025);
        Header.SHOW_NOTES.Set(0x0026);
        Header.TROCK_LOCATIONS.Set(0x0027);
        // 0x0028
        // 0x0029
        // 0x002A
        // 0x002B
        // 0x002C
        Header.UPDATE_MOUNT.Set(0x002D);
        Header.SHOW_QUEST_COMPLETION.Set(0x002E);
        Header.SEND_TITLE_BOX.Set(0x002F);
        Header.USE_SKILL_BOOK.Set(0x0030);
        Header.FINISH_SORT.Set(0x0031);
        Header.FINISH_GATHER.Set(0x0032);
        // 0x0033
        // 0x0034
        Header.CHAR_INFO.Set(0x0035);
        Header.PARTY_OPERATION.Set(0x0036);
        // 0x0037
        Header.EXPEDITION_OPERATION.Set(0x0038);
        Header.BUDDYLIST.Set(0x0039);
        // 0x003A
        Header.GUILD_OPERATION.Set(0x003B);
        Header.ALLIANCE_OPERATION.Set(0x003C);
        Header.SPAWN_PORTAL.Set(0x003D);
        // 0x003E
        Header.SERVERMESSAGE.Set(0x003F);
        Header.PIGMI_REWARD.Set(0x0040);
        Header.OWL_OF_MINERVA.Set(0x0041);
        // 0x0042
        Header.ENGAGE_REQUEST.Set(0x0043);
        Header.ENGAGE_RESULT.Set(0x0044);
        // 0x0045
        // 0x0046
        // 0x0047
        Header.YELLOW_CHAT.Set(0x0048);
        // 0x0049
        // 0x004A
        // 0x004B
        // 0x004C
        // 0x004D
        // 0x004E
        // 0x004F
        // 0x0050
        Header.FISHING_BOARD_UPDATE.Set(0x0051);
        // 0x0052
        // 0x0053
        // 0x0054
        // 0x0055
        Header.PLAYER_NPC.Set(0x0056);
        Header.MONSTERBOOK_ADD.Set(0x0057);
        Header.MONSTERBOOK_CHANGE_COVER.Set(0x0058);
        // 0x0059 BBS_OPERATION?
        // 0x005A
        Header.AVATAR_MEGA.Set(0x005B);
        // 0x005C
        // 0x005D
        // 0x005E
        // 0x005F
        // 0x0060
        // 0x0061
        Header.ENERGY.Set(0x0062);
        Header.GHOST_POINT.Set(0x0063);
        Header.GHOST_STATUS.Set(0x0064);
        Header.FAIRY_PEND_MSG.Set(0x0065);
        Header.SEND_PEDIGREE.Set(0x0066);
        Header.OPEN_FAMILY.Set(0x0067);
        Header.FAMILY_MESSAGE.Set(0x0068);
        Header.FAMILY_INVITE.Set(0x0069);
        Header.FAMILY_JUNIOR.Set(0x006A);
        Header.SENIOR_MESSAGE.Set(0x006B);
        Header.FAMILY.Set(0x006C);
        Header.REP_INCREASE.Set(0x006D);
        Header.FAMILY_LOGGEDIN.Set(0x006E);
        Header.FAMILY_BUFF.Set(0x006F);
        Header.FAMILY_USE_REQUEST.Set(0x0070);
        Header.LEVEL_UPDATE.Set(0x0071);
        Header.MARRIAGE_UPDATE.Set(0x0072);
        Header.JOB_UPDATE.Set(0x0073);
        // 0x0074
        Header.FOLLOW_REQUEST.Set(0x0075);
        // 0x0076
        Header.TOP_MSG.Set(0x0077);
        // 0x0078 GM chatbox?
        // 0x0079
        // 0x007A
        // 0x007B
        // 0x007C
        Header.SKILL_MACRO.Set(0x007D);
        Header.WARP_TO_MAP.Set(0x007E);
        Header.MTS_OPEN.Set(0x007F);
        Header.CS_OPEN.Set(0x0080);
        // 0x0081
        // 0x0082
        // 0x0083
        // 0x0084
        Header.SERVER_BLOCKED.Set(0x0085);
        Header.SHOW_EQUIP_EFFECT.Set(0x0086);
        Header.MULTICHAT.Set(0x0087);
        Header.WHISPER.Set(0x0088);
        Header.BLOCK_PORTAL.Set(0x0089);
        Header.BOSS_ENV.Set(0x008A);
        Header.MOVE_ENV.Set(0x008B);
        Header.UPDATE_ENV.Set(0x008C);
        // 0x008D
        Header.MAP_EFFECT.Set(0x008E);
        Header.CASH_SONG.Set(0x008F);
        Header.GM_EFFECT.Set(0x0090);
        Header.OX_QUIZ.Set(0x0091);
        Header.GMEVENT_INSTRUCTIONS.Set(0x0092);
        Header.CLOCK.Set(0x0093);
        Header.BOAT_EFF.Set(0x0094);
        Header.BOAT_EFFECT.Set(0x0095);
        // 0x0096
        // 0x0097
        // 0x0098
        Header.STOP_CLOCK.Set(0x0099);
        // 0x009A
        // 0x009B
        Header.PYRAMID_UPDATE.Set(0x009C);
        Header.PYRAMID_RESULT.Set(0x009D);
        // 0x009E
        Header.MOVE_PLATFORM.Set(0x009F);
        // 0x00A0
        Header.SPAWN_PLAYER.Set(0x00A1);
        Header.REMOVE_PLAYER_FROM_MAP.Set(0x00A2);
        Header.CHATTEXT.Set(0x00A3);
        Header.CHATTEXT1.Set(0x00A4);
        Header.CHALKBOARD.Set(0x00A5);
        Header.UPDATE_CHAR_BOX.Set(0x00A6);
        // 0x00A7
        Header.SHOW_SCROLL_EFFECT.Set(0x00A8);
        // 0x00A9
        // 0x00AA
        Header.SHOW_POTENTIAL_RESET.Set(0x00AB);
        Header.SHOW_POTENTIAL_EFFECT.Set(0x00AC);
        // 0x00AD Damage Effect
        // 0x00AE
        // 0x00AF
        // 0x00B0
        Header.FOLLOW_EFFECT.Set(0x00B1);
        Header.FISHING_CAUGHT.Set(0x00B2);
        Header.PAMS_SONG.Set(0x00B3);
        Header.SPAWN_PET.Set(0x00B4);
        // 0x00B5
        // 0x00B6
        Header.MOVE_PET.Set(0x00B7);
        Header.PET_CHAT.Set(0x00B8);
        Header.PET_NAMECHANGE.Set(0x00B9);
        // 0x00BA
        Header.PET_COMMAND.Set(0x00BB);
        Header.SPAWN_SUMMON.Set(0x00BC);
        Header.REMOVE_SUMMON.Set(0x00BD);
        Header.MOVE_SUMMON.Set(0x00BE);
        Header.SUMMON_ATTACK.Set(0x00BF);
        Header.SUMMON_SKILL.Set(0x00C0);
        Header.DAMAGE_SUMMON.Set(0x00C1);
        Header.DRAGON_SPAWN.Set(0x00C2);
        Header.DRAGON_MOVE.Set(0x00C3);
        Header.DRAGON_REMOVE.Set(0x00C4);
        // 0x00C5
        Header.MOVE_PLAYER.Set(0x00C6);
        Header.CLOSE_RANGE_ATTACK.Set(0x00C7);
        Header.RANGED_ATTACK.Set(0x00C8);
        Header.MAGIC_ATTACK.Set(0x00C9);
        Header.ENERGY_ATTACK.Set(0x00CA);
        Header.SKILL_EFFECT.Set(0x00CB);
        Header.CANCEL_SKILL_EFFECT.Set(0x00CC);
        Header.DAMAGE_PLAYER.Set(0x00CD);
        Header.FACIAL_EXPRESSION.Set(0x00CE);
        Header.SHOW_ITEM_EFFECT.Set(0x00CF);
        // 0x00D0
        Header.SHOW_CHAIR.Set(0x00D1);
        Header.UPDATE_CHAR_LOOK.Set(0x00D2);
        Header.SHOW_FOREIGN_EFFECT.Set(0x00D3);
        Header.GIVE_FOREIGN_BUFF.Set(0x00D4);
        Header.CANCEL_FOREIGN_BUFF.Set(0x00D5);
        Header.UPDATE_PARTYMEMBER_HP.Set(0x00D6);
        Header.LOAD_GUILD_NAME.Set(0x00D7);
        Header.LOAD_GUILD_ICON.Set(0x00D8);
        // 0x00D9
        Header.CANCEL_CHAIR.Set(0x00DA);
        // 0x00DB
        Header.SHOW_ITEM_GAIN_INCHAT.Set(0x00DC);
        Header.CURRENT_MAP_WARP.Set(0x00DD);
        // 0x00DE
        Header.MESOBAG_SUCCESS.Set(0x00DF);
        Header.MESOBAG_FAILURE.Set(0x00E0);
        Header.RANDOM_MESOBAG_SUCCESS.Set(0x00E1);
        Header.RANDOM_MESOBAG_FAILURE.Set(0x00E2);
        Header.UPDATE_QUEST_INFO.Set(0x00E3);
        // 0x00E4
        // 0x00E5
        // 0x00E6
        // 0x00E7
        Header.PLAYER_HINT.Set(0x00E8);
        // 0x00E9
        // 0x00EA
        // 0x00EB
        // 0x00EC
        Header.REPAIR_WINDOW.Set(0x00ED);
        Header.CYGNUS_INTRO_LOCK.Set(0x00EE);
        Header.CYGNUS_INTRO_DISABLE_UI.Set(0x00EF);
        Header.SUMMON_HINT.Set(0x00F0);
        Header.SUMMON_HINT_MSG.Set(0x00F1);
        Header.ARAN_COMBO.Set(0x00F2);
        Header.TAMA_BOX_SUCCESS.Set(0x00F3);
        Header.TAMA_BOX_FAILURE.Set(0x00F4);
        // 0x00F5
        // 0x00F6
        // 0x00F7
        // 0x00F8
        // 0x00F9
        Header.GAME_POLL_REPLY.Set(0x00FA);
        Header.FOLLOW_MESSAGE.Set(0x00FB);
        // 0x00FC
        // 0x00FD
        // 0x00FE
        Header.FOLLOW_MOVE.Set(0x00FF);
        Header.FOLLOW_MSG.Set(0x0100);
        Header.GAME_POLL_QUESTION.Set(0x0101);
        Header.COOLDOWN.Set(0x0102);
        // 0x0103
        Header.SPAWN_MONSTER.Set(0x0104);
        Header.KILL_MONSTER.Set(0x0105);
        Header.SPAWN_MONSTER_CONTROL.Set(0x0106);
        Header.MOVE_MONSTER.Set(0x0107);
        Header.MOVE_MONSTER_RESPONSE.Set(0x0108);
        // 0x0109
        Header.APPLY_MONSTER_STATUS.Set(0x010A);
        Header.CANCEL_MONSTER_STATUS.Set(0x010B);
        // 0x010C
        Header.MOB_TO_MOB_DAMAGE.Set(0x010D);
        Header.DAMAGE_MONSTER.Set(0x010E);
        // 0x010F
        // 0x0110
        // 0x0111
        Header.SHOW_MONSTER_HP.Set(0x0112);
        Header.SHOW_MAGNET.Set(0x0113);
        Header.CATCH_MONSTER.Set(0x0114);
        Header.MOB_SPEAKING.Set(0x0115);
        // 0x0116
        Header.MONSTER_PROPERTIES.Set(0x0117);
        Header.REMOVE_TALK_MONSTER.Set(0x0118);
        Header.TALK_MONSTER.Set(0x0119);
        // 0x011A
        // 0x011B
        // 0x011C
        // 0x011D
        Header.SPAWN_NPC.Set(0x011E);
        Header.REMOVE_NPC.Set(0x011F);
        Header.SPAWN_NPC_REQUEST_CONTROLLER.Set(0x0120);
        Header.NPC_ACTION.Set(0x0121);
        // 0x0122
        // 0x0123
        // 0x0124
        // 0x0125
        Header.SPAWN_HIRED_MERCHANT.Set(0x0126);
        Header.DESTROY_HIRED_MERCHANT.Set(0x0127);
        Header.UPDATE_HIRED_MERCHANT.Set(0x0128);
        Header.DROP_ITEM_FROM_MAPOBJECT.Set(0x0129);
        Header.REMOVE_ITEM_FROM_MAP.Set(0x012A);
        Header.KITE_MESSAGE.Set(0x012B);
        Header.SPAWN_KITE.Set(0x012C);
        Header.REMOVE_KITE.Set(0x012D);
        Header.SPAWN_MIST.Set(0x012E);
        Header.REMOVE_MIST.Set(0x012F);
        Header.SPAWN_DOOR.Set(0x0130);
        Header.REMOVE_DOOR.Set(0x0131);
        // 0x0132
        // 0x0133
        // 0x0134 crash
        // 0x0135 ポータルを開けませんでした。
        // 0x0136
        Header.REACTOR_HIT.Set(0x0137);
        // 0x0138
        Header.REACTOR_SPAWN.Set(0x0139);
        Header.REACTOR_DESTROY.Set(0x013A);
        Header.ROLL_SNOWBALL.Set(0x013B);
        Header.HIT_SNOWBALL.Set(0x013C);
        Header.SNOWBALL_MESSAGE.Set(0x013D);
        Header.LEFT_KNOCK_BACK.Set(0x013E);
        Header.HIT_COCONUT.Set(0x013F);
        Header.COCONUT_SCORE.Set(0x0140);
        // 0x0141
        // 0x0142
        Header.MONSTER_CARNIVAL_START.Set(0x0143);
        Header.MONSTER_CARNIVAL_OBTAINED_CP.Set(0x0144);
        Header.MONSTER_CARNIVAL_PARTY_CP.Set(0x0145);
        Header.MONSTER_CARNIVAL_SUMMON.Set(0x0146);
        // 0x0147
        Header.MONSTER_CARNIVAL_DIED.Set(0x0148);
        // 0x0149
        // 0x014A
        // 0x014B
        // 0x014C
        // 0x014D
        // 0x014E
        // 0x014F
        // 0x0150
        Header.CHAOS_HORNTAIL_SHRINE.Set(0x0151);
        Header.CHAOS_ZAKUM_SHRINE.Set(0x0152);
        Header.HORNTAIL_SHRINE.Set(0x0153);
        Header.ZAKUM_SHRINE.Set(0x0154);
        Header.NPC_TALK.Set(0x0155);
        Header.OPEN_NPC_SHOP.Set(0x0156);
        Header.CONFIRM_SHOP_TRANSACTION.Set(0x0157);
        // 0x0158
        // 0x0159
        Header.OPEN_STORAGE.Set(0x015A);
        Header.MERCH_ITEM_MSG.Set(0x015B);
        Header.MERCH_ITEM_STORE.Set(0x015C);
        Header.RPS_GAME.Set(0x015D);
        Header.MESSENGER.Set(0x015E);
        Header.PLAYER_INTERACTION.Set(0x015F);
        // 0x0160
        // 0x0161
        // 0x0162
        // 0x0163
        // 0x0164
        // 0x0165
        // 0x0166
        Header.TIP_BEANS.Set(0x0167);
        Header.OPEN_BEANS.Set(0x0168);
        Header.SHOOT_BEANS.Set(0x0169);
        // 0x016A
        Header.UPDATE_BEANS.Set(0x016B);
        // 0x016C
        // 0x016D
        // 0x016E
        Header.CS_UPDATE.Set(0x016F);
        Header.CS_OPERATION.Set(0x0170);
        // 0x0171
        // 0x0172
        // 0x0173
        // 0x0174
        // 0x0175
        // 0x0176
        // 0x0177
        // 0x0178
        // 0x0179
        // 0x017A
        // 0x017B
        Header.KEYMAP.Set(0x017C);
        Header.PET_AUTO_HP.Set(0x017D);
        Header.PET_AUTO_MP.Set(0x017E);
        // 0x017F
        // 0x0180
        // 0x0181
        // 0x0182
        // 0x0183
        // 0x0184
        // 0x0185
        // 0x0186
        // 0x0187
        Header.GET_MTS_TOKENS.Set(0x0188);
        Header.MTS_OPERATION.Set(0x0189);
    }

}
