package de.gravitex.railstuff;

public enum MaturityRenderMode {

	PX_48(48, 2), PX_96(96, 4), PX_144(144, 6), PX_192(192, 8), PX_240(240, 10), PX_288(288, 12), PX_336(336, 14), PX_384(384, 16);

	private int renderWidth;

	private int hourOffset;

	MaturityRenderMode(int renderWidth, int hourOffset) {
		this.renderWidth = renderWidth;
		this.hourOffset = hourOffset;
	}

	public int getRenderWidth() {
		return this.renderWidth;
	}

	public int hourOffset() {
		return this.hourOffset;
	}

	public int dayOffset() {
		return hourOffset() * 24;
	}

	public int renderSteps() {
		switch (this) {
		case PX_144:
			return 4;
		case PX_384:
			return 12;
		default:
			return 2;
		}
	}

	public MaturityRenderMode following() {
		switch (this) {
		case PX_48:
			return PX_96;
		case PX_96:
			return PX_144;
		case PX_144:
			return PX_192;
		case PX_192:
			return PX_240;
		case PX_240:
			return PX_288;
		case PX_288:
			return PX_336;
		case PX_336:
			return PX_384;
		case PX_384:
			return null;
		}
		return null;
	}

	public MaturityRenderMode predecessing() {
		switch (this) {
		case PX_48:
			return null;
		case PX_96:
			return PX_48;
		case PX_144:
			return PX_96;
		case PX_192:
			return PX_144;
		case PX_240:
			return PX_192;
		case PX_288:
			return PX_240;
		case PX_336:
			return PX_288;
		case PX_384:
			return PX_336;
		}
		return null;
	}
}
