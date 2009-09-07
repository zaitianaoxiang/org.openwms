/*
 * OpenWMS, the Open Warehouse Management System
 * 
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package org.openwms.common.domain.values {

    import org.granite.util.Enum;

    [Bindable]
    [RemoteClass(alias="org.openwms.common.domain.values.Barcode$BARCODE_ALIGN")]
    public class Barcode$BARCODE_ALIGN extends Enum {

        public static const LEFT:Barcode$BARCODE_ALIGN = new Barcode$BARCODE_ALIGN("LEFT", _);
        public static const RIGHT:Barcode$BARCODE_ALIGN = new Barcode$BARCODE_ALIGN("RIGHT", _);

        function Barcode$BARCODE_ALIGN(value:String = null, restrictor:* = null) {
            super((value || LEFT.name), restrictor);
        }

        override protected function getConstants():Array {
            return constants;
        }

        public static function get constants():Array {
            return [LEFT, RIGHT];
        }

        public static function valueOf(name:String):Barcode$BARCODE_ALIGN {
            return Barcode$BARCODE_ALIGN(LEFT.constantOf(name));
        }
    }
}