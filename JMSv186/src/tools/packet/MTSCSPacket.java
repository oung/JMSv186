/*
This file is part of the OdinMS Maple Story Server
Copyright (C) 2008 ~ 2010 Patrick Huy <patrick.huy@frz.cc> 
Matthias Butz <matze@odinms.de>
Jan Christian Meyer <vimes@odinms.de>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License version 3
as published by the Free Software Foundation. You may not use, modify
or distribute this program under any other version of the
GNU Affero General Public License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tools.packet;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import client.MapleClient;
import client.MapleCharacter;
import client.inventory.IItem;
import server.CashShop;
import server.CashItemFactory;
import server.CashItemInfo;
import server.CashItemInfo.CashModInfo;
import handling.MaplePacket;
import constants.ServerConstants;
import tools.Pair;
import java.util.Map;
import java.util.Map.Entry;
import packet.InPacket;
import server.MTSStorage.MTSItemInfo;
import tools.HexTool;
import tools.KoreanDateUtil;
import tools.data.output.MaplePacketLittleEndianWriter;

public class MTSCSPacket {

    private static final byte[] warpCS = HexTool.getByteArrayFromHexString("00 00 00 63 00 74 00 65 00 64 00 2F 00 32 00 00 00 00 00 02 00 11 00 AD 01 08 06 02 00 00 00 33 00 00 00 05 00 13 00 AF 00 08 06 A0 01 14 00 30 E1 7B 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 00 18 00 B2 01 08 06 02 00 00 00 33 00 00 00 08 00 1A 00 B4 00 0A 06 B8 01 14 00 A8 10 88 06 69 00 6C 00 6C 00 2F 00 39 00 30 00 30 00 31 00");
    //private static final byte[] warpCS = HexTool.getByteArrayFromHexString("07 00 C2 53 10 00 01 00 62 FC 08 00 00 00 5A 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 01 FF 00 00 00 00 00 00 00 00 BE DB 3B 01 FF FF 07 00 AE 7E 10 00 01 00 62 54 0B 00 00 00 5A 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 01 02 00 00 00 00 00 00 00 00 E4 63 3D 01 FF FF 07 00 88 F4 19 00 01 00 62 B4 14 00 00 00 5A 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 01 02 00 00 00 00 00 00 00 00 8F F6 41 01 FF FF 07 00 E0 C8 10 00 01 00 62 EC 13 00 00 00 5A 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 01 FF 00 00 00 00 00 00 00 00 90 F6 41 01 FF FF 07 00 B5 D1 10 00 01 00 62 04 10 00 00 00 5A 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 01 02 00 00 00 00 00 00 00 00 06 1E 2C 04 FF FF 07 00 10 E4 8A 00 01 00 63 48 3F 00 00 00 5A 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 01 02 00 00 00 00 00 00 00 02 67 A1 98 00 68 A1 98 00 67 B5 C4 04 FF FF 07 00 0B 2E 1F 00 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 FF 00 FF 00 00 00 00 00 00 00 00 C1 8C 6C 05 80 00 00 00 40 42 0F 00 C1 8C 6C 05 80 00 00 00 20 A1 07 00 00 00 00 30 00 25 00 00 00 00 00 10 00 10 00 44 00 0A 06 98 BA 50 01 50 D3 B1 04 20 00 2D 00 20 00 34 00 34 00 20 00 2C 00 20 00 66 00 6F 00 72 00 20 00 35 00 39 00 73 00 65 00 63 00 73 00 2C 00 20 00 52 00 61 00 6E 00 67 00 65 00 20 00 32 00 30 00 30 00 25 00 00 00 00 00 03 00 0A 00 72 01 0C 06 06 00 00 00 68 00 32 00 39 00 00 00 00 00 00 00 03 00 0D 00");

    public static MaplePacket warpCS(MapleClient c) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPEN.Get());

        PacketHelper.addCharacterInfo(mplew, c.getPlayer());

        // 0048BDCF +16172 Buffer(1080)
        // 0048C403 +17252 WORD
        // 0048C44A +17254 WORD
        // 0047FFA8 +17256 BYTE
        
        mplew.writeZeroBytes(1500);
        /*        Collection<CashModInfo> cmi = CashItemFactory.getInstance().getAllModInfo();
        mplew.writeShort(cmi.size());
        for (CashModInfo cm : cmi) {
            addModCashItemInfo(mplew, cm);
        }
        mplew.write(warpCS);
        int[] itemz = CashItemFactory.getInstance().getBestItems();
        for (int i = 1; i <= 8; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int item : itemz) {
                    mplew.writeInt(i);
                    mplew.writeInt(j);
                    mplew.writeInt(item);
                }
            }
        }
        mplew.writeShort(0); //stock
        mplew.writeShort(0); //limited goods 1-> A2 35 4D 00 CE FD FD 02 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 00 00 00 FF FF FF FF FF FF FF FF 06 00 00 00 1F 1C 32 01 A7 3F 32 01 FF FF FF FF FF FF FF FF 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 00
        mplew.write(0); //eventON
        mplew.writeInt(0);*/

        return mplew.getPacket();
    }

    public static MaplePacket playCashSong(int itemid, String name) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.CASH_SONG.Get());
        mplew.writeInt(itemid);
        mplew.writeMapleAsciiString(name);
        return mplew.getPacket();
    }

    public static MaplePacket useCharm(byte charmsleft, byte daysleft) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.SHOW_ITEM_GAIN_INCHAT.Get());
        mplew.write(6);
        mplew.write(1);
        mplew.write(charmsleft);
        mplew.write(daysleft);

        return mplew.getPacket();
    }

    public static MaplePacket useWheel(byte charmsleft) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.SHOW_ITEM_GAIN_INCHAT.Get());
        mplew.write(21);
        mplew.writeLong(charmsleft);

        return mplew.getPacket();
    }

    public static MaplePacket itemExpired(int itemid) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        // 1E 00 02 83 C9 51 00

        // 21 00 08 02
        // 50 62 25 00
        // 50 62 25 00
        mplew.writeShort(InPacket.Header.SHOW_STATUS_INFO.Get());
        mplew.write(2);
        mplew.writeInt(itemid);

        return mplew.getPacket();
    }

    public static MaplePacket changePetName(MapleCharacter chr, String newname, int slot) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.PET_NAMECHANGE.Get());

        mplew.writeInt(chr.getId());
        mplew.write(0);
        mplew.writeMapleAsciiString(newname);
        mplew.write(slot);

        return mplew.getPacket();
    }

    public static MaplePacket showNotes(ResultSet notes, int count) throws SQLException {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.SHOW_NOTES.Get());
        mplew.write(3);
        mplew.write(count);
        for (int i = 0; i < count; i++) {
            mplew.writeInt(notes.getInt("id"));
            mplew.writeMapleAsciiString(notes.getString("from"));
            mplew.writeMapleAsciiString(notes.getString("message"));
            mplew.writeLong(PacketHelper.getKoreanTimestamp(notes.getLong("timestamp")));
            mplew.write(notes.getInt("gift"));
            notes.next();
        }

        return mplew.getPacket();
    }

    public static MaplePacket useChalkboard(final int charid, final String msg) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.CHALKBOARD.Get());

        mplew.writeInt(charid);
        if (msg == null || msg.length() <= 0) {
            mplew.write(0);
        } else {
            mplew.write(1);
            mplew.writeMapleAsciiString(msg);
        }

        return mplew.getPacket();
    }

    public static MaplePacket getTrockRefresh(MapleCharacter chr, boolean vip, boolean delete) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.TROCK_LOCATIONS.Get());
        mplew.write(delete ? 2 : 3);
        mplew.write(vip ? 1 : 0);
        if (vip) {
            int[] map = chr.getRocks();
            for (int i = 0; i < 10; i++) {
                mplew.writeInt(map[i]);
            }
        } else {
            int[] map = chr.getRegRocks();
            for (int i = 0; i < 5; i++) {
                mplew.writeInt(map[i]);
            }
        }
        return mplew.getPacket();
    }

    public static MaplePacket sendWishList(MapleCharacter chr, boolean update) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(update ? 0x56 : 0x52); //+12
        int[] list = chr.getWishlist();
        for (int i = 0; i < 10; i++) {
            mplew.writeInt(list[i] != -1 ? list[i] : 0);
        }
        return mplew.getPacket();
    }

    public static MaplePacket showNXMapleTokens(MapleCharacter chr) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_UPDATE.Get());
        mplew.writeInt(chr.getCSPoints(1)); // A-cash
        mplew.writeInt(chr.getCSPoints(2)); // MPoint

        return mplew.getPacket();
    }

    public static MaplePacket showBoughtCSPackage(Map<Integer, IItem> ccc, int accid) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x8C); //use to be 7a
        mplew.write(ccc.size());
        for (Entry<Integer, IItem> sn : ccc.entrySet()) {
            addCashItemInfo(mplew, sn.getValue(), accid, sn.getKey().intValue());
        }
        mplew.writeShort(0);

        return mplew.getPacket();
    }

    public static MaplePacket showBoughtCSItem(int itemid, int sn, int uniqueid, int accid, int quantity, String giftFrom, long expire) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x58/*0x5A*/); //use to be 4a
        addCashItemInfo(mplew, uniqueid, accid, itemid, sn, quantity, giftFrom, expire);

        return mplew.getPacket();
    }

    public static MaplePacket showBoughtCSItem(IItem item, int sn, int accid) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x58/*0x5A*/);
        addCashItemInfo(mplew, item, accid, sn);

        return mplew.getPacket();
    }

    public static MaplePacket showXmasSurprise(int idFirst, IItem item, int accid) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.XMAS_SURPRISE.Get());
        mplew.write(0xE6);
        mplew.writeLong(idFirst); //uniqueid of the xmas surprise itself
        mplew.writeInt(0);
        addCashItemInfo(mplew, item, accid, 0); //info of the new item, but packet shows 0 for sn?
        mplew.writeInt(item.getItemId());
        mplew.write(1);
        mplew.write(1);

        return mplew.getPacket();
    }

    public static final void addCashItemInfo(MaplePacketLittleEndianWriter mplew, IItem item, int accId, int sn) {
        addCashItemInfo(mplew, item, accId, sn, true);
    }

    public static final void addCashItemInfo(MaplePacketLittleEndianWriter mplew, IItem item, int accId, int sn, boolean isFirst) {
        addCashItemInfo(mplew, item.getUniqueId(), accId, item.getItemId(), sn, item.getQuantity(), item.getGiftFrom(), item.getExpiration(), isFirst); //owner for the lulz
    }

    public static final void addCashItemInfo(MaplePacketLittleEndianWriter mplew, int uniqueid, int accId, int itemid, int sn, int quantity, String sender, long expire) {
        addCashItemInfo(mplew, uniqueid, accId, itemid, sn, quantity, sender, expire, true);
    }

    public static final void addCashItemInfo(MaplePacketLittleEndianWriter mplew, int uniqueid, int accId, int itemid, int sn, int quantity, String sender, long expire, boolean isFirst) {
        mplew.writeLong(uniqueid > 0 ? uniqueid : 0);
        mplew.writeLong(accId);
        mplew.writeInt(itemid);
        mplew.writeInt(isFirst ? sn : 0);
        mplew.writeShort(quantity);
        mplew.writeAsciiString(sender, 13); //owner for the lulzlzlzl
        PacketHelper.addExpirationTime(mplew, expire);
        mplew.writeLong(isFirst ? 0 : sn);
        //if (isFirst && uniqueid > 0 && GameConstants.isEffectRing(itemid)) {
        //	MapleRing ring = MapleRing.loadFromDb(uniqueid);
        //	if (ring != null) { //or is this only for friendship rings, i wonder. and does isFirst even matter
        //		mplew.writeMapleAsciiString(ring.getPartnerName());
        //		mplew.writeInt(itemid);
        //		mplew.writeShort(quantity);
        //	}
        //}
    }

    public static void addModCashItemInfo(MaplePacketLittleEndianWriter mplew, CashModInfo item) {
        int flags = item.flags;
        mplew.writeInt(item.sn);
        mplew.writeInt(flags);
        if ((flags & 0x1) != 0) {
            mplew.writeInt(item.itemid);
        }
        if ((flags & 0x2) != 0) {
            mplew.writeShort(item.count);
        }
        if ((flags & 0x4) != 0) {
            mplew.writeInt(item.discountPrice);
        }
        if ((flags & 0x8) != 0) {
            mplew.write(item.unk_1 - 1);
        }
        if ((flags & 0x10) != 0) {
            mplew.write(item.priority);
        }
        if ((flags & 0x20) != 0) {
            mplew.writeShort(item.period);
        }
        if ((flags & 0x40) != 0) {
            mplew.writeInt(0);
        }
        if ((flags & 0x80) != 0) {
            mplew.writeInt(item.meso);
        }
        if ((flags & 0x100) != 0) {
            mplew.write(item.unk_2 - 1);
        }
        if ((flags & 0x200) != 0) {
            mplew.write(item.gender);
        }
        if ((flags & 0x400) != 0) {
            mplew.write(item.showUp ? 1 : 0);
        }
        if ((flags & 0x800) != 0) {
            mplew.write(item.mark);
        }
        if ((flags & 0x1000) != 0) {
            mplew.write(item.unk_3 - 1);
        }
        if ((flags & 0x2000) != 0) {
            mplew.writeShort(0);
        }
        if ((flags & 0x4000) != 0) {
            mplew.writeShort(0);
        }
        if ((flags & 0x8000) != 0) {
            mplew.writeShort(0);
        }
        if ((flags & 0x10000) != 0) {
            List<CashItemInfo> pack = CashItemFactory.getInstance().getPackageItems(item.sn);
            if (pack == null) {
                mplew.write(0);
            } else {
                mplew.write(pack.size());
                for (int i = 0; i < pack.size(); i++) {
                    mplew.writeInt(pack.get(i).getSN());
                }
            }
        }
    }

    public static MaplePacket showBoughtCSQuestItem(int price, short quantity, byte position, int itemid) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x90);
        mplew.writeInt(price);
        mplew.writeShort(quantity);
        mplew.writeShort(position);
        mplew.writeInt(itemid);

        return mplew.getPacket();
    }

    public static MaplePacket sendCSFail(int err) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x68);
        mplew.write(err);

        return mplew.getPacket();
    }

    public static MaplePacket showCouponRedeemedItem(int itemid) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.writeShort(0x60);
        mplew.writeInt(0);
        mplew.writeInt(1);
        mplew.writeShort(1);
        mplew.writeShort(0x1A);
        mplew.writeInt(itemid);
        mplew.writeInt(0);

        return mplew.getPacket();
    }

    public static MaplePacket showCouponRedeemedItem(Map<Integer, IItem> items, int mesos, int maplePoints, MapleClient c) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x60); //use to be 4c
        mplew.write(items.size());
        for (Entry<Integer, IItem> item : items.entrySet()) {
            addCashItemInfo(mplew, item.getValue(), c.getAccID(), item.getKey().intValue());
        }
        mplew.writeLong(maplePoints);
        mplew.writeInt(mesos);

        return mplew.getPacket();
    }

    public static MaplePacket enableCSUse() {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(0x0A);
        mplew.write(1);
        mplew.writeInt(0);

        return mplew.getPacket();
    }

    public static MaplePacket getCSInventory(MapleClient c) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x4E); // use to be 3e
        CashShop mci = c.getPlayer().getCashInventory();
        mplew.writeShort(mci.getItemsSize());
        for (IItem itemz : mci.getInventory()) {
            addCashItemInfo(mplew, itemz, c.getAccID(), 0); //test
        }
        mplew.writeShort(c.getPlayer().getStorage().getSlots());
        mplew.writeInt(c.getCharacterSlots());
        mplew.writeShort(4); //00 00 04 00 <-- added?

        return mplew.getPacket();
    }

    //work on this packet a little more
    public static MaplePacket getCSGifts(MapleClient c) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());

        mplew.write(0x50); //use to be 40
        List<Pair<IItem, String>> mci = c.getPlayer().getCashInventory().loadGifts();
        mplew.writeShort(mci.size());
        for (Pair<IItem, String> mcz : mci) {
            mplew.writeLong(mcz.getLeft().getUniqueId());
            mplew.writeInt(mcz.getLeft().getItemId());
            mplew.writeAsciiString(mcz.getLeft().getGiftFrom(), 13);
            mplew.writeAsciiString(mcz.getRight(), 73);
        }

        return mplew.getPacket();
    }

    public static MaplePacket cashItemExpired(int uniqueid) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x71); //use to be 5d
        mplew.writeLong(uniqueid);
        return mplew.getPacket();
    }

    public static MaplePacket sendGift(int price, int itemid, int quantity, String receiver) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x8E); //use to be 7C
        mplew.writeMapleAsciiString(receiver);
        mplew.writeInt(itemid);
        mplew.writeShort(quantity);
        mplew.writeShort(0); //maplePoints
        mplew.writeInt(price);

        return mplew.getPacket();
    }

    public static MaplePacket increasedInvSlots(int inv, int slots) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x63);
        mplew.write(inv);
        mplew.writeShort(slots);

        return mplew.getPacket();
    }

    //also used for character slots !
    public static MaplePacket increasedStorageSlots(int slots) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x65);
        mplew.writeShort(slots);

        return mplew.getPacket();
    }

    public static MaplePacket confirmFromCSInventory(IItem item, short pos) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x6B);
        mplew.writeShort(pos);
        PacketHelper.addItemInfo(mplew, item, true, true);

        return mplew.getPacket();
    }

    public static MaplePacket confirmToCSInventory(IItem item, int accId, int sn) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.CS_OPERATION.Get());
        mplew.write(0x6D);
        addCashItemInfo(mplew, item, accId, sn, false);

        return mplew.getPacket();
    }

    public static MaplePacket sendMesobagFailed() {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MESOBAG_FAILURE.Get());
        return mplew.getPacket();
    }

    public static MaplePacket sendMesobagSuccess(int mesos) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MESOBAG_SUCCESS.Get());
        mplew.writeInt(mesos);
        return mplew.getPacket();
    }

    public static MaplePacket RandomMesoBagSuccess(byte type, int mesos) {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.RANDOM_MESOBAG_SUCCESS.Get());
        mplew.write(type);
        mplew.writeInt(mesos);
        return mplew.getPacket();
    }

    public static MaplePacket RandomMesoBagFailed() {
        MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.RANDOM_MESOBAG_FAILURE.Get());
        return mplew.getPacket();
    }

//======================================MTS===========================================
    public static final MaplePacket startMTS(final MapleCharacter chr) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPEN.Get());

        PacketHelper.addCharacterInfo(mplew, chr);
        mplew.writeMapleAsciiString(chr.getClient().getAccountName());
        mplew.writeInt(ServerConstants.MTS_MESO);
        mplew.writeInt(ServerConstants.MTS_TAX);
        mplew.writeInt(ServerConstants.MTS_BASE);
        mplew.writeInt(24);
        mplew.writeInt(168);
        mplew.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        return mplew.getPacket();
    }

    public static final MaplePacket sendMTS(final List<MTSItemInfo> items, final int tab, final int type, final int page, final int pages) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x15); //operation
        mplew.writeInt(pages * 10); //total items
        mplew.writeInt(items.size()); //number of items on this page
        mplew.writeInt(tab);
        mplew.writeInt(type);
        mplew.writeInt(page);
        mplew.write(1);
        mplew.write(1);

        for (MTSItemInfo item : items) {
            addMTSItemInfo(mplew, item);
        }
        mplew.write(0); //0 or 1?

        return mplew.getPacket();
    }

    public static final MaplePacket showMTSCash(final MapleCharacter p) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.GET_MTS_TOKENS.Get());
        mplew.writeInt(p.getCSPoints(1));
        mplew.writeInt(p.getCSPoints(2));
        return mplew.getPacket();
    }

    public static final MaplePacket getMTSWantedListingOver(final int nx, final int items) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x3D);
        mplew.writeInt(nx);
        mplew.writeInt(items);
        return mplew.getPacket();
    }

    public static final MaplePacket getMTSConfirmSell() {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x1D);
        return mplew.getPacket();
    }

    public static final MaplePacket getMTSFailSell() {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x1E);
        mplew.write(0x42);
        return mplew.getPacket();
    }

    public static final MaplePacket getMTSConfirmBuy() {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x33);
        return mplew.getPacket();
    }

    public static final MaplePacket getMTSFailBuy() {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x34);
        mplew.write(0x42);
        return mplew.getPacket();
    }

    public static final MaplePacket getMTSConfirmCancel() {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x25);
        return mplew.getPacket();
    }

    public static final MaplePacket getMTSFailCancel() {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x26);
        mplew.write(0x42);
        return mplew.getPacket();
    }

    public static final MaplePacket getMTSConfirmTransfer(final int quantity, final int pos) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();
        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x27);
        mplew.writeInt(quantity);
        mplew.writeInt(pos);
        return mplew.getPacket();
    }

    private static final void addMTSItemInfo(final MaplePacketLittleEndianWriter mplew, final MTSItemInfo item) {
        PacketHelper.addItemInfo(mplew, item.getItem(), true, true);
        mplew.writeInt(item.getId()); //id
        mplew.writeInt(item.getTaxes()); //this + below = price
        mplew.writeInt(item.getPrice()); //price
        mplew.writeLong(0);
        mplew.writeInt(KoreanDateUtil.getQuestTimestamp(item.getEndingDate()));
        mplew.writeInt(KoreanDateUtil.getQuestTimestamp(item.getEndingDate()));
        mplew.writeMapleAsciiString(item.getSeller()); //account name (what was nexon thinking?)
        mplew.writeMapleAsciiString(item.getSeller()); //char name
        mplew.writeZeroBytes(28);
    }

    public static final MaplePacket getNotYetSoldInv(final List<MTSItemInfo> items) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x23);

        mplew.writeInt(items.size());

        for (MTSItemInfo item : items) {
            addMTSItemInfo(mplew, item);
        }

        return mplew.getPacket();
    }

    public static final MaplePacket getTransferInventory(final List<IItem> items, final boolean changed) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        mplew.write(0x21);

        mplew.writeInt(items.size());
        int i = 0;
        for (IItem item : items) {
            PacketHelper.addItemInfo(mplew, item, true, true);
            mplew.writeInt(Integer.MAX_VALUE - i); //fake ID
            mplew.writeInt(110);
            mplew.writeInt(1011); //fake
            mplew.writeZeroBytes(48);
            i++;
        }
        mplew.writeInt(-47 + i - 1);
        mplew.write(changed ? 1 : 0);

        return mplew.getPacket();
    }

    public static final MaplePacket addToCartMessage(boolean fail, boolean remove) {
        final MaplePacketLittleEndianWriter mplew = new MaplePacketLittleEndianWriter();

        mplew.writeShort(InPacket.Header.MTS_OPERATION.Get());
        if (remove) {
            if (fail) {
                mplew.write(0x2C);
                mplew.writeInt(-1);
            } else {
                mplew.write(0x2B);
            }
        } else {
            if (fail) {
                mplew.write(0x2A);
                mplew.writeInt(-1);
            } else {
                mplew.write(0x29);
            }
        }

        return mplew.getPacket();
    }
}
